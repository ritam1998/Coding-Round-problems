package leetcodeproblems.arrayproblems;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1,2}));
    }
    /**
     * @1207. Unique Number of Occurrences
     * @https://leetcode.com/problems/unique-number-of-occurrences/description/
     * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
     *
     *
     * Example 1:
     *
     * Input: arr = [1,2,2,1,1,3]
     * Output: true
     * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
     * Example 2:
     *
     * Input: arr = [1,2]
     * Output: false
     * Example 3:
     *
     * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * Output: true
     * */
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> list = Arrays.stream(arr)
                .boxed()
                .sorted()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        long count = list.values().stream().distinct().count();
        return list.size() == count;
    }
}
