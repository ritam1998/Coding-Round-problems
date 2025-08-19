package leetcodeproblems.dailyleetcodeproblems;

public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubArray(new int[]{1,3,0,0,2,0,0,4}));
    }
    /**
     * @LeetCode
     * @2348. Number of Zero-Filled Subarrays
     * @https://leetcode.com/problems/number-of-zero-filled-subarrays/description/?envType=daily-question&envId=2025-08-19
     *
     * Given an integer array nums, return the number of subarrays filled with 0.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * Example 1:
     *
     * Input: nums = [1,3,0,0,2,0,0,4]
     * Output: 6
     * Explanation:
     * There are 4 occurrences of [0] as a subarray.
     * There are 2 occurrences of [0,0] as a subarray.
     * There is no occurrence of a subarray with a size more than 2 filled with 0. Therefore, we return 6.
     * Example 2:
     *
     * Input: nums = [0,0,0,2,0,0]
     * Output: 9
     * Explanation:
     * There are 5 occurrences of [0] as a subarray.
     * There are 3 occurrences of [0,0] as a subarray.
     * There is 1 occurrence of [0,0,0] as a subarray.
     * There is no occurrence of a subarray with a size more than 3 filled with 0. Therefore, we return 9.
     * Example 3:
     *
     * Input: nums = [2,10,2019]
     * Output: 0
     * Explanation: There is no subarray filled with 0. Therefore, we return 0.
     * */
    public static long zeroFilledSubArray(int[] nums) {
        long result = 0;
        long zero = 0;
        for(Integer number : nums){
            if(number == 0){
                zero = zero + 1;
                result = result + zero;
            }else zero = 0;
        }
        return result;
    }
}
