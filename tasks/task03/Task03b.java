package tasks.task03;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Task03b {
    public static void main(String[] args) {
        try (var scanner = new Scanner(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Введите два числа через пробел");
                double dividend, divisor;
                try {
                    dividend = scanner.nextDouble();
                    divisor = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("В качестве разделителя между частями числа используйте ','");
                    break;
                }
                if (divisor == 0.0)
                    break;
                 else
                     System.out.println(dividend / divisor);
            }
        }
    }
}
