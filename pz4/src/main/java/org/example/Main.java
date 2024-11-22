import com.github.javafaker.Faker;
import org.example.Clothing;
import org.example.OrderProcessor;

public void main() {

    var faker = new Faker();
    var clothing = Clothing.builder()
            .name(faker.commerce().productName())
            .price(Double.parseDouble(faker.commerce().price().replace(",",".")))
            .description(faker.lebowski().quote())
            .build();
    OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);

    var clothingList  = IntStream.range(0, 100000000).mapToObj(i -> Clothing.builder()
                    .name(faker.commerce().productName())
                    .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                    .description(faker.lebowski().quote())
                    .build())
            .toList();
    clothingList.parallelStream()
            .map(OrderProcessor::new)
            .forEach(OrderProcessor::startProcessing);
}
