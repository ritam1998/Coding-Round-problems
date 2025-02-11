package leetcodeproblems.arrayproblems;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs {
    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4,1,3,3}));
    }
    /**
     * @LeetCode
     * @2364. Count Number of Bad Pairs
     * @Important
     * @Optimization
     * @https://leetcode.com/problems/count-number-of-bad-pairs/description/?envType=daily-question&envId=2025-02-09
     *
     * You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].
     *
     * Return the total number of bad pairs in nums.
     *
     *
     * Example 1:
     *
     * Input: nums = [4,1,3,3]
     * Output: 5
     * Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
     * The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
     * The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
     * The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
     * The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
     * There are a total of 5 bad pairs, so we return 5.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: 0
     * Explanation: There are no bad pairs.
     * */
    public static long countBadPairs(int[] nums) {
        int count = 0;

        for(int i = 0;i<nums.length/2;i++){
            for(int j = 0;j<nums.length/2;j++){
                int index = j - i;
                if((i < j) && (index != (nums[j] - nums[i]))){
                    count++;
                }
            }
        }
        return count;
    }
    public long countBadPair(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;
        long goodPairs = 0;

        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];
            goodPairs += freq.getOrDefault(diff, 0);
            freq.put(diff, freq.getOrDefault(diff, 0) + 1);
        }
        return totalPairs - goodPairs;
    }
}
