package leetcodeproblems.dailyleetcodeproblems;

public class LongestSubArrayOf1sAfterDeletingOneElement {
    public static void main(String[] args) {
        System.out.println(longestSubArray(new int[]{0,1,1,1,0,1,1,0,1}));
    }
    /**
     * @Leetcode
     * @1493. Longest Subarray of 1's After Deleting One Element
     * @https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=daily-question&envId=2025-08-24
     *
     * Given a binary array nums, you should delete one element from it.
     *
     * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1]
     * Output: 3
     * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
     * Example 2:
     *
     * Input: nums = [0,1,1,1,0,1,1,0,1]
     * Output: 5
     * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
     * Example 3:
     *
     * Input: nums = [1,1,1]
     * Output: 2
     * Explanation: You must delete one element.
     * */
    public static int longestSubArray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink the window if more than one zero is present
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum length of the valid subarray
            // The length is right - left because we're looking for the length of
            // the subarray *after* deleting one element.
            maxLength = Math.max(maxLength, right - left);
        }

        // If the original array had no zeros, we still must delete one element.
        // The loop will result in maxLength being n-1, which is correct.
        // If all elements are ones, the code returns n-1. If n=1 and nums=[0],
        // it returns 0. If n=1 and nums=[1], it returns 0.
        // It correctly handles all cases.
        return maxLength;
    }
}
