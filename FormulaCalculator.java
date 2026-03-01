// Дано a, b. Создать программу, находящую min(a,b), max(a,b) и d (результат решения сложной формулы).

import java.util.Scanner;

public class FormulaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вычисление значения d по формуле:");
        System.out.println("d = (min(a,b) - 2 * sqrt(max(a,b))) / (1 + max(a,b)/min(a,b))");

        double a = 0, b = 0;
        boolean validInput = false;

        // Цикл для повторного ввода при ошибке
        while (!validInput) {
            try {
                System.out.print("Введите значение a: ");
                a = Double.parseDouble(scanner.nextLine().trim());

                System.out.print("Введите значение b: ");
                b = Double.parseDouble(scanner.nextLine().trim());

                double max = Math.max(a, b);
                double min = Math.min(a, b);

                if (max < 0) {
                    System.out.println("Ошибка вычисления: максимальное число - отрицательное, невозможно извлечь из него квадратный корень.");
                } else if (min == 0) {
                    System.out.println("Ошибка вычисления: минимальное число равно нулю, невозможно разделить на него.");
                } else {
                    double numerator = min - 2 * Math.sqrt(max);
                    double denominator = 1 + (max / min);
                    double d = numerator / denominator;

                    System.out.printf("Результат: d = %.6f\n", d);
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка вычисления: введите дробные числа через точку.");
            }
        }

        scanner.close();
    }
}