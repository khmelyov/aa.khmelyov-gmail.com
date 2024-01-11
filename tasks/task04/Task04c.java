package tasks.task04;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Task04c {
    public static void main(String[] args) {
        int m = 12;
        int n = 8;
        int[][] matrix = new int[m][n];
        Random random = new Random();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(51);
            }
        }

        int maxSum = 0;
        int maxSumRowIndex = -1;

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
            if (sum >= maxSum) {
                maxSum = sum;
                maxSumRowIndex = i;
            }
        }

        int[] rowSums = Arrays.stream(matrix)
                .mapToInt(row -> Arrays.stream(row).sum())
                .toArray();

        int maxSum2 = Arrays.stream(rowSums).max().orElse(0);

        int idxOfMaxSum = IntStream.range(0, rowSums.length)
                .reduce((first, second) -> rowSums[second] == maxSum2 ? second : first)
                .orElse(-1);

        System.out.println("Индекс строки с максимальной суммой чисел: " + maxSumRowIndex);
        System.out.println("Индекс последней строки с максимальной суммой чисел через стримы: " + idxOfMaxSum);

        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
