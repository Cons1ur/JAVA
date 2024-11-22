package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.println("Введите первое число:");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.println("Введите второе число:");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Выберите операцию (+, -, *, /):");
            String operation = scanner.nextLine();

            double result = 0;
            switch (operation) {
                case "+":
                    result = calculator.add(num1, num2);
                    break;
                case "-":
                    result = calculator.subtract(num1, num2);
                    break;
                case "*":
                    result = calculator.multiply(num1, num2);
                    break;
                case "/":
                    try {
                        result = calculator.divide(num1, num2);
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                        return;
                    }
                    break;
                default:
                    throw new InvalidInputException("Ошибка: Неправильная операция.");
            }

            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите корректные числа.");
        } catch (InvalidInputException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println("Обработка запроса завершена.");
            scanner.close();
        }
    }
}
