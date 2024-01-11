package tasks.task04;

import java.util.Random;

public class Task04d {
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int maxSum = 0;
        int maxIndex = -1;

        for (int i = 0; i < array.length - 2; i++) {
            int sum = array[i] + array[i + 1] + array[i + 2];
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = i;
            }
        }

        System.out.println("Максимальная сумма трех соседних элементов: " + maxSum);
        System.out.println("Индекс первого элемента тройки: " + maxIndex);
    }
}
