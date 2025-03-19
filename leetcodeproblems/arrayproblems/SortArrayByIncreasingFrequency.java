package leetcodeproblems.arrayproblems;

import java.util.*;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort(new int[]{2,3,1,3,2}));
    }
    /**
     * @LeetCode {@Tricky}
     * @Important
     * @1636. Sort Array by Increasing Frequency
     * @https://leetcode.com/problems/sort-array-by-increasing-frequency/description/
     *
     * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
     *
     * Return the sorted array.
     *
     * Example 1:
     *
     * Input: nums = [1,1,2,2,2,3]
     * Output: [3,1,1,2,2,2]
     * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
     * Example 2:
     *
     * Input: nums = [2,3,1,3,2]
     * Output: [1,3,3,2,2]
     * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
     * Example 3:
     *
     * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
     * Output: [5,-1,4,4,-6,-6,1,1,1]
     * */
    public static int[] frequencySort(int[] nums) {

        Map<Integer, Integer> seen = new HashMap<>();
        for (int num : nums) seen.put(num, seen.getOrDefault(num, 0) + 1);

        /**
         * if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by descending numeric value
         * */
        return Arrays.stream(nums).boxed()
                .sorted((a,b) -> !Objects.equals(seen.get(a), seen.get(b)) ? seen.get(a)-seen.get(b) : b - a)
                .mapToInt(i->i)
                .toArray();
    }
}
