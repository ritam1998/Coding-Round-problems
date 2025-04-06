package leetcodeproblems.binarysearchproblems;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
    }
    /**
     * @LeetCode
     * @Important
     * @Sliding window problem
     * @209. Minimum Size Sub-array Sum
     * @https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=problem-list-v2&envId=binary-search
     *
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     * Example 2:
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     * Example 3:
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     * */
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int right = 0;
        int currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(right = 0;right<nums.length;right++){
            currentSum += nums[right];
            while(currentSum >= target){
                minLength = Math.min(minLength,right-left+1);
                currentSum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;
    }
}
