package tasks.task04;

import java.util.*;
import java.util.stream.IntStream;

public class Task04d {

    static class TripletSumResult {
        int sum;
        int index;

        TripletSumResult(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }

    static TripletSumResult findMaxTripletSum(int[] array) {
        if (array.length < 3) return null;

        int maxSum = array[0] + array[1] + array[2];
        int maxIndex = 0;

        for (int i = 1; i < array.length - 2; i++) {
            int currentSum = array[i] + array[i + 1] + array[i + 2];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxIndex = i;
            }
        }
        return new TripletSumResult(maxSum, maxIndex);
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        // ------------------------------------ //

        int maxSum = 0;
        int maxIndex = -1;

        for (int i = 0; i < array.length - 2; i++) {
            int sum = array[i] + array[i + 1] + array[i + 2];
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = i;
            }
        }

        // ------------------------------------ //
        int maxIndex2 = IntStream.range(0, array.length - 2)
                .mapToObj(i -> new int[]{i, array[i] + array[i + 1] + array[i + 2]})
                .max(Comparator.comparingInt(a -> a[1]))
                .orElse(new int[]{-1, 0})[0];

        int maxSum2 = maxIndex2 == -1 ? 0 : array[maxIndex2] + array[maxIndex2 + 1] + array[maxIndex2 + 2];

        // ------------------------------------ //

        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            sumList.add(array[i] + array[i + 1] + array[i + 2]);
        }

        int maxIndex3 = IntStream.range(0, sumList.size())
                .boxed()
                .max(Comparator.comparing(sumList::get))
                .orElse(-1);

        int maxSum3 = maxIndex3 == -1 ? 0 : sumList.get(maxIndex3);

        // ------------------------------------ //

        Optional<AbstractMap.SimpleEntry<Integer, Integer>> maxSumEntry =
                IntStream.range(0, array.length - 2)
                        .mapToObj(i -> new AbstractMap.SimpleEntry<>(i, array[i] + array[i + 1] + array[i + 2]))
                        .reduce((a, b) -> a.getValue() > b.getValue() ? a : b);

        if (maxSumEntry.isPresent()) {
            AbstractMap.SimpleEntry<Integer, Integer> entry = maxSumEntry.get();
            System.out.println("Максимальная сумма трех соседних элементов: " + entry.getValue());
            System.out.println("Индекс первого элемента в тройке с максимальной суммой: " + entry.getKey());
        } else {
            System.out.println("Не удалось найти максимальную сумму.");
        }

        // ------------------------------------ //

        TripletSumResult classResult = findMaxTripletSum(array);

        // ------------------------------------ //

        int maxSum4;
        int maxIndex4 = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            queue.add(array[i]);
        }
        int currentSum = queue.stream().mapToInt(Integer::intValue).sum();
        maxSum4 = currentSum;

        for (int i = 3; i < array.length; i++) {
            currentSum -= queue.poll();
            queue.add(array[i]);
            currentSum += array[i];
            if (currentSum > maxSum4) {
                maxSum4 = currentSum;
                maxIndex4 = i - 2;
            }
        }

        // ------------------------------------ //

        System.out.println("Максимальная сумма трех соседних элементов: " + maxSum);
        System.out.println("Индекс первого элемента в тройке с максимальной суммой: " + maxIndex);

        System.out.println("Максимальная сумма трех соседних элементов: " + maxSum2);
        System.out.println("Индекс первого элемента в тройке с максимальной суммой: " + maxIndex2);

        System.out.println("Максимальная сумма трех соседних элементов: " + maxSum3);
        System.out.println("Индекс первого элемента тройки: " + maxIndex3);

        if (classResult != null) {
            System.out.println("Максимальная сумма трех соседних элементов: " + classResult.sum);
            System.out.println("Индекс первого элемента в тройке с максимальной суммой: " + classResult.index);
        } else {
            System.out.println("Не удалось найти максимальную сумму.");
        }

        System.out.println("Максимальная сумма трех соседних элементов: " + maxSum4);
        System.out.println("Индекс первого элемента тройки: " + maxIndex4);
    }
}
