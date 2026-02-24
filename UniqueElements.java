//Определить одномерный массив и заполнить его случайными значениями
//Составить и вывести на экран массив номеров элементов исходного массива, встречающихся один раз

import java.util.Arrays;
import java.util.Random;

public class UniqueElements {
    public static void main(String[] arguments) {
        Random random_number = new Random();

        int[] originalArray = new int[50];

        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = random_number.nextInt(101);
        }
        int uniqueCount = 0;
        for (int i = 0; i < originalArray.length; i++) {
            int current = originalArray[i];
            int count = 0;
            for (int j = 0; j < originalArray.length; j++) {
                if (originalArray[j] == current) {
                    count++;
                }
            }
            if (count == 1) {
                uniqueCount++;
            }
        }
        int[] indexArray = new int[uniqueCount];
        int pos = 0;
        for (int i = 0; i < originalArray.length; i++) {
            int current = originalArray[i];
            int count = 0;

            for (int j = 0; j < originalArray.length; j++) {
                if (originalArray[j] == current) {
                    count++;
                }
            }
            if (count == 1) {
                indexArray[pos] = i;
                pos++;
            }
        }
        System.out.println("Индексы заданного массива, соответствующие уникальным значениям:");
        if (indexArray.length > 0) {
            System.out.println(Arrays.toString(indexArray));
            System.out.println("Количество уникальных элементов: " + indexArray.length);
        } else {
            System.out.println("В исходном массиве нет уникальных элементов (все числа повторяются).");
        }
    }
}