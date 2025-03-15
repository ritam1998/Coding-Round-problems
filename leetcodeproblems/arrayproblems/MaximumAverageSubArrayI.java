package leetcodeproblems.arrayproblems;

public class MaximumAverageSubArrayI {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    /**
     * @Sliding Window Problem: {@Fixed Sliding Window}
     * @Important
     * @Leetcode
     * @643. Maximum Average Sub-array I
     * @https://leetcode.com/problems/maximum-average-subarray-i/description/
     * You are given an integer array nums consisting of n elements, and an integer k.
     *
     * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
     *
     * Example 1:
     *
     * Input: nums = [1,12,-5,-6,50,3], k = 4
     * Output: 12.75000
     * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
     * Example 2:
     *
     * Input: nums = [5], k = 1
     * Output: 5.00000
     * */
    public static double findMaxAverage(int[] nums, int k) {

        int sum = 0;
        /**
         * Compute the sum of the first 'k' elements
         */
        for(int i = 0;i<k;i++) sum += nums[i];
        int maxSum = sum;

        for(int i = k;i<nums.length;i++){
            sum += nums[i];     // Add new element entering window
            sum -= nums[i-k];   // Remove element leaving window
            maxSum = Math.max(maxSum,sum); // Update maxSum
        }
        return (double) maxSum/k;
    }
}
