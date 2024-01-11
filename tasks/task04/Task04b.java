package tasks.task04;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Task04b {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 100;
        int[] array = IntStream.generate(() -> random.nextInt(10000)).limit(size).toArray();
        int max = array[0];
        int min = array[0];
        int endingOnZero = 0;
        int sumEndingOnZero = 0;
        for (var number : array) {
            max = Math.max(number, max);
            min = Math.min(number, min);
            if (number % 10 == 0) {
                endingOnZero++;
                sumEndingOnZero += number;
            }
        }

        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
        System.out.println("Количество чисел окончащивающихся на 0: " + endingOnZero);
        System.out.println("Сумма чисел окончащивающихся на 0: " + sumEndingOnZero);

        OptionalInt maxNumberOpt = Arrays.stream(array).max();
        OptionalInt minNumberOpt = Arrays.stream(array).min();

        long countEndsWithZero = Arrays.stream(array)
                .filter(number -> number % 10 == 0)
                .count();

        int sumEndsWithZero = Arrays.stream(array)
                .filter(number -> number % 10 == 0)
                .sum();

        maxNumberOpt.ifPresent(maxNumber -> System.out.println("Наибольший элемент массива: " + maxNumber));
        minNumberOpt.ifPresent(minNumber -> System.out.println("Наименьший элемент массива: " + minNumber));
        System.out.println("Количество элементов массива, оканчивающихся на 0: " + countEndsWithZero);
        System.out.println("Сумма элементов массива, оканчивающихся на 0: " + sumEndsWithZero);
    }
}