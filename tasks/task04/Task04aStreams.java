package tasks.task04;

import java.util.stream.IntStream;
import java.util.Random;
import java.util.Scanner;

public class Task04aStreams {

    static class StatisticsAccumulator {
        int count = 0;
        int countMoreThan8 = 0;
        int countEquals1 = 0;
        int countEven = 0;
        int countOdd = 0;
        int sum = 0;

        void include(int number) {
            if (number > 8) countMoreThan8++;
            if (number == 1) countEquals1++;
            if (number % 2 == 0) countEven++;
            else countOdd++;
            sum += number;
            count++;
        }

        StatisticsAccumulator combine(StatisticsAccumulator other) {
            countMoreThan8 += other.countMoreThan8;
            countEquals1 += other.countEquals1;
            countEven += other.countEven;
            countOdd += other.countOdd;
            sum += other.sum;
            count++;
            return this;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        try (var scanner = new Scanner(System.in)) {
            System.out.println("Введите число n: ");
            int n = scanner.nextInt();
            int[] array = IntStream.generate(() -> random.nextInt(20)).limit(n).toArray();

            IntStream.of(array).forEach(System.out::println);

            long count = IntStream.of(array).count();
            long countMoreThan8 = IntStream.of(array).filter(num -> num > 8).count();
            long countEquals1 = IntStream.of(array).filter(num -> num == 1).count();
            long countEven = IntStream.of(array).filter(num -> num % 2 == 0).count();
            long countOdd = n - countEven;
            int sum = IntStream.of(array).sum();

            StatisticsAccumulator stats = java.util.Arrays.stream(array)
                    .collect(
                            StatisticsAccumulator::new,
                            StatisticsAccumulator::include,
                            StatisticsAccumulator::combine
                    );

            System.out.println("Длина массива: " + stats.count);
            System.out.println("Количество чисел больше 8: " + stats.countMoreThan8);
            System.out.println("Количество чисел равных 1: " + stats.countEquals1);
            System.out.println("Количество четных чисел: " + stats.countEven);
            System.out.println("Количество нечетных чисел: " + stats.countOdd);
            System.out.println("Сумма всех элементов массива: " + stats.sum);

            System.out.println("----");

            System.out.println("Длина массива: " + count);
            System.out.println("Количество чисел больше 8: " + countMoreThan8);
            System.out.println("Количество чисел равных 1: " + countEquals1);
            System.out.println("Количество четных чисел: " + countEven);
            System.out.println("Количество нечетных чисел: " + countOdd);
            System.out.println("Сумма всех элементов массива: " + sum);

          /*  int countMoreThan9 = 0;
            , countEquals1_, countEven_, countOdd_, sum_ = 0;
            for (var number: array) {
                if (number > 8) countMoreThan9++;
                if (number == 1) countEquals1_++;
                if (number % 2 == 0) countEven++;
                else countOdd++;
                sum += number;
            } */
        }
    }
}
