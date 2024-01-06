package tasks.task01;

public class Task01 {
    public static final String JAVA = "JAVA";

    public static void main(String[] args) {
        task1aWhile();
        System.out.println("\n---");
        task1aFor();
        System.out.println("\n---");
        task1bWhile();
        System.out.println("\n---");
        task1bFor();
        System.out.println("\n---");
        task1cWhile();
        System.out.println("\n---");
        task1cFor();
        System.out.println("---");
        task1d();
    }

    public static void task1aWhile() {
        int i = 0;
        while (i < 10) {
            System.out.print(JAVA);
            i++;
        }
    }

    public static void task1aFor() {
        for (int i = 0; i < 10; i++) {
            System.out.print(JAVA);
        }
    }

    public static void task1bWhile() {
        int i = 0;
        while (i < 10) {
            System.out.println(JAVA);
            i++;
        }
    }

    public static void task1bFor() {
        for (int i = 0; i < 10; i++) {
            System.out.println(JAVA);
        }
    }

    public static void task1cWhile() {
        int i = 1980;
        while (i <= 2020) {
            System.out.println("Олимпиада " + i + " года");
            i+=4;
        }
    }

    public static void task1cFor() {
        for (int i = 1980; i <= 2020; i+=4) {
            System.out.println("Олимпиада " + i + " года");
        }
    }

    public static void task1d() {
        int k = 5;
        for (int i = 1; i < 10; i ++) {
            System.out.println(i + " x " + k + " = " + k * i);
        }
    }
}
