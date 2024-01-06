package tasks.task02;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Task02 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Задача 1 - укажите этажность");
        task2a(console.nextInt());
        System.out.println("Задача 2 - укажите два числа промежутка");
        task2bFor(console.nextInt(), console.nextInt());
        System.out.println("Задача 2b - укажите два числа промежутка");
        task2bWhile(console.nextInt(), console.nextInt());
        System.out.println("Задача 2c - укажите два числа промежутка");
        task2bStream(console.nextInt(), console.nextInt());
        System.out.println("Задача 3 - укажите число");
        System.out.println(task2c(console.nextDouble()));
        console.close();
    }

    public static void task2a(int height) {
        if (height > 0 && height < 5)
            System.out.println("Малоэтажный дом");
        else if (height >= 5 && height <= 8)
            System.out.println("Среднеэтажный дом");
        else if (height > 8)
            System.out.println("Многоэтажный дом");
        else
            System.out.println("Ошибка ввода");
    }

    public static void task2bFor(int from, int to) {
        StringBuilder s = new StringBuilder();
        for (int i = from; i <= to; i++) {
            if (i % 10 != 0 && i % 5 == 0) {
                s.append(i).append(" ");
            }
        }
        System.out.println(s);
    }

    public static void task2bWhile(int from, int to) {
        StringBuilder s = new StringBuilder();
        int i = from;
        do {
            if (i % 10 != 0 && i % 5 == 0) {
                s.append(i).append(" ");
            }
            i++;
        } while (i <= to);
        System.out.println(s);
    }

    public static void task2bStream(int from, int to) {
        StringBuilder s = new StringBuilder();
        IntStream
                .rangeClosed(from, to)
                .forEach(i -> {
                    if (i % 10 != 0 && i % 5 == 0) { s.append(i).append(" "); }
                });

        System.out.println(s);
    }

    public static double task2c(double a) {
        if (a >= 5) {
            return (a * a - 10) / (a + 7);
        } else if (a > -3) {
            return (a + 3) * (a * a - 2);
        }
        else return 420;
    }
}
