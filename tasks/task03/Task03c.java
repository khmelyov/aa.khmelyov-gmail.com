package tasks.task03;

import java.util.Scanner;

public class Task03c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите делимое: ");
            double dividend = scanner.nextDouble();

            System.out.println("Введите делитель: ");
            double divisor = scanner.nextDouble();

            if (divisor == 0) {
                System.out.println("Деление на 0");
                continue;
            }

            double result = dividend / divisor;
            System.out.println("Результат деления: " + result);
        }

        scanner.close();
    }
}
