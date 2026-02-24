// Определить матрицу (двумерный массив) и ее заполнить случайными значениями.
// Построить вектор В, которой возвращает: 1, если значения элементов i-й строки упорядочены по возрастанию, и 0, в противном случае;

import java.util.Random;

public class VectorFromMatrix {
    public static void main(String[] args) {
        final int LINE = 5;
        final int COLUMN = 2;
        int[][] matrix = new int[LINE][COLUMN];
        Random random = new Random();

        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < LINE; i++) {
            for (int j = 0; j < COLUMN; j++) {
                matrix[i][j] = random.nextInt(10) + 1; // 1..10
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int[] B = new int[LINE];
        for (int i = 0; i < LINE; i++) {
            boolean increasing = true;
            boolean decreasing = true;

            for (int j = 0; j < COLUMN - 1; j++) {
                if (matrix[i][j] >= matrix[i][j + 1]) {
                    increasing = false;
                }
                if (matrix[i][j] <= matrix[i][j + 1]) {
                    decreasing = false;
                }
            }

            if (increasing) {
                B[i] = 1;
            } else if (decreasing) {
                B[i] = 0;
            } else {
                B[i] = -1;
            }
        }

        System.out.println("\nВектор B (1 - возрастание; 0 - убывание; -1 - иной вывод):");
        for (int value : B) {
            System.out.print(value + " ");
        }
    }
}