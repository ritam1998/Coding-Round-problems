package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class CountSubArraysOfLengthThreeWithACondition {
    public static void main(String[] args) {
        System.out.println(countSubArrays(new int[]{-1,18,-11,-4}));
    }
    /**
     * @3392. Count Subarrays of Length Three With a Condition
     * @https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition/description/?envType=daily-question&envId=2025-04-27
     *
     * Given an integer array nums, return the number of subarrays of length 3 such that the sum of the first and third numbers equals exactly half of the second number.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,1,4,1]
     *
     * Output: 1
     *
     * Explanation:
     *
     * Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.
     *
     * Example 2:
     *
     * Input: nums = [1,1,1]
     *
     * Output: 0
     *
     * Explanation:
     *
     * [1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.
     * */
    public static int countSubArrays(int[] nums) {

        List<List<Integer>> set = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sumOfFirstAndThirdNumber = nums[i] + nums[k];
                int halfOfSecondNumber = nums[j] / 2;
                if(sumOfFirstAndThirdNumber == halfOfSecondNumber){
                    set.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sumOfFirstAndThirdNumber < halfOfSecondNumber) j++;
                else k--;
            }
        }
        System.out.println(set);
        return set.size();
    }
    /**
     * @LeetCode Solution
     * */
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == (nums[i - 1] + nums[i + 1]) * 2) {
                ++ans;
            }
        }
        return ans;
    }
}
