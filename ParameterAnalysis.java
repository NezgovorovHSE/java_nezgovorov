// Написать программу, получающую на вход в качестве аргумента два параметра - числа а и b.
// Если произведение двух чисел больше 20, то вычислить котангенс второго числа, в противном случае первое число разделить на 3.
// Вывести результат на экран.

import java.util.Scanner;

public class ParameterAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите число b: ");
        double b = scanner.nextDouble();

        scanner.close();

        double result;
        double product = a * b;

        if (product > 20) {
            double tanB = Math.tan(b);
            if (Math.abs(tanB) < 1e-12) {
                System.out.println("Котангенс b не определён (tan(b) близок к нулю).");
                return;
            } else {
                result = 1.0 / tanB;
            }
        } else {
            result = a / 3.0;
        }

        System.out.println("Результат: " + result);
    }
}