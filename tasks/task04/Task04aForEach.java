package tasks.task04;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task04aForEach{

    public static void main(String[] args) {
        int count = 0;
        int countMoreThan8 = 0;
        int countEquals1 = 0;
        int countEven = 0;
        int countOdd = 0;
        int sum = 0;
        Random random = new Random();
        try (var scanner = new Scanner(System.in)) {
            System.out.println("Введите число n: ");
            int n = scanner.nextInt();
            int[] array = IntStream.generate(() -> random.nextInt(20)).limit(n).toArray();

            IntStream.of(array).forEach(System.out::println);

            for (var number: array) {
                if (number > 8) countMoreThan8++;
                if (number == 1) countEquals1++;
                if (number % 2 == 0) countEven++;
                else countOdd++;
                sum += number;
                count++;
            }

            System.out.println("Длина массива: " + count);
            System.out.println("Количество чисел больше 8: " + countMoreThan8);
            System.out.println("Количество чисел равных 1: " + countEquals1);
            System.out.println("Количество четных чисел: " + countEven);
            System.out.println("Количество нечетных чисел: " + countOdd);
            System.out.println("Сумма всех элементов массива: " + sum);
        }
    }
}
