package tasks.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task03a {
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Введите название города:");
                String city = reader.readLine();
                switch (city) {
                    case "Москва", "Ростов", "Владивосток" -> System.out.println("Россия");
                    case "Рим", "Милан", "Турин" -> System.out.println("Италия");
                    case "Ливерпуль", "Манчестер", "Лондон" -> System.out.println("Англия");
                    case "Берлин", "Мюнхен", "Кёльн" -> System.out.println("Германия");
                    case "Stop" -> {
                        System.out.println("программа завершила работу");
                        return;
                    }
                    default -> System.out.println("Неизвестная страна");
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
