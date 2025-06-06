package leetcodeproblems.sortingproblems;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1,2,3,4}));
    }
    /**
     * @Leetcode
     * @628. Maximum Product of Three Numbers
     * @https://leetcode.com/problems/maximum-product-of-three-numbers/description/?envType=problem-list-v2&envId=sorting
     *
     * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: 6
     * Example 2:
     *
     * Input: nums = [1,2,3,4]
     * Output: 24
     * Example 3:
     *
     * Input: nums = [-1,-2,-3]
     * Output: -6
     * */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3],
                nums[0] * nums[1] * nums[n - 1]);
    }
}
