package leetcode.java;

import java.util.Arrays;
import java.util.HashMap;

public class task1 {

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]) && i != map.get(target - numbers[i])) {
                return new int[]{i, map.get(target - numbers[i])};
            }
            map.put(numbers[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
