package leetcodeproblems.arrayproblems;

import java.util.HashSet;
import java.util.Set;

public class MinimumOperationsToMakeArrayValuesEqualToK {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5,2,5,4,5},2));
    }
    /**
     * @Leetcode
     * @Important
     * @Tricky
     * @3375. Minimum Operations to Make Array Values Equal to K
     * @https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09
     *
     * You are given an integer array nums and an integer k.
     *
     * An integer h is called valid if all values in the array that are strictly greater than h are identical.
     *
     * For example, if nums = [10, 8, 10, 8], a valid integer is h = 9 because all nums[i] > 9 are equal to 10, but 5 is not a valid integer.
     *
     * You are allowed to perform the following operation on nums:
     *
     * Select an integer h that is valid for the current values in nums.
     * For each index i where nums[i] > h, set nums[i] to h.
     * Return the minimum number of operations required to make every element in nums equal to k. If it is impossible to make all elements equal to k, return -1.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,2,5,4,5], k = 2
     *
     * Output: 2
     *
     * Explanation:
     *
     * The operations can be performed in order using valid integers 4 and then 2.
     *
     * Example 2:
     *
     * Input: nums = [2,1,2], k = 2
     *
     * Output: -1
     *
     * Explanation:
     *
     * It is impossible to make all the values equal to 2.
     *
     * Example 3:
     *
     * Input: nums = [9,7,5,3], k = 1
     *
     * Output: 4
     *
     * Explanation:
     *
     * The operations can be performed using valid integers in the order 7, 5, 3, and 1.
     * */
    public static int minOperations(int[] nums, int k) {
        Set<Integer> integerSet = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < k) return -1;
            if(nums[i] == k) continue;
            integerSet.add(nums[i]);
        }
        return integerSet.size();
    }
}
