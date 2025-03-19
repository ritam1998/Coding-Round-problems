package leetcodeproblems.arrayproblems;


public class LongestNiceSubArray {
    public static void main(String[] args) {
        System.out.println(longestNiceSubArray(new int[]{1,3,8,48,10}));
    }
    /**
     * @Leetcode
     * @Important
     * @SlidingWindowProblems
     * @2401. Longest Nice Sub-array
     * @https://leetcode.com/problems/longest-nice-subarray/description/?envType=daily-question&envId=2025-03-18
     *
     * You are given an array nums consisting of positive integers.
     *
     * We call a sub-array of nums nice if the bitwise AND of every pair of elements that are in different positions in the sub-array is equal to 0.
     *
     * Return the length of the longest nice sub-array.
     *
     * A sub-array is a contiguous part of an array.
     *
     * Note that sub-arrays of length 1 are always considered nice.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,8,48,10]
     * Output: 3
     * Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
     * - 3 AND 8 = 0.
     * - 3 AND 48 = 0.
     * - 8 AND 48 = 0.
     * It can be proven that no longer nice subarray can be obtained, so we return 3.
     * Example 2:
     *
     * Input: nums = [3,1,5,11,13]
     * Output: 1
     * Explanation: The length of the longest nice subarray is 1. Any subarray of length 1 can be chosen.
     *
     * */
    public static int longestNiceSubArray(int[] nums) {

        /**
         * @ALgorithm
         * Solved using {@SlidingWindow}
         * Initialize variables:
         * {@Step-1:} usedBits to 0, which tracks the bits currently used in the sliding window.
         * {@Step-2:} windowStart to 0, representing the starting position of the current window.
         * {@Step-3:} maxLength to 0, which will store the length of the longest nice sub-array found.
         * {@Step-4:} Iterate through the array with a variable windowEnd from 0 to the length of nums:
         * {@Step-4.1:} While the current number at windowEnd shares any bits with the usedBits (their bitwise AND is not 0):
         * {@Step-4.1.1:} Remove the bits of the leftmost element in the window from usedBits using bitwise XOR.
         * {@Step-4.1.2:} Increment windowStart to shrink the window from the left.
         * {@Step-4.2:} Add the bits of the current number to usedBits using bitwise OR.
         * {@Step-4.3:} Update maxLength to the maximum of the current maxLength and the current window size (calculated as windowEnd - windowStart + 1).
         * {@Step-5:} Return the final maxLength.
         * */

        int maxLength = 0;
        int left = 0;
        int usedBits = 0;
        for(int right = 0;right<nums.length;right++){
            while ((usedBits&nums[right]) != 0){
                usedBits ^= nums[left];
                left++;
            }
            usedBits = usedBits | nums[right];
            maxLength = Math.max(maxLength,right - left + 1);
        }
        return maxLength;
    }
}
