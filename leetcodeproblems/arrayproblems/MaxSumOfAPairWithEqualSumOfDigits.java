package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{10,12,19,14}));
        System.out.println(maximumSumLeetCodeSolution(new int[]{18,43,36,13,7}));
    }
    /**
     * @Leetcode
     * @Important
     * @2342. Max Sum of a Pair With Equal Sum of Digits
     * @https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/?envType=daily-question&envId=2025-02-12
     *
     * You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].
     *
     * Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.
     *
     * Example 1:
     *
     * Input: nums = [18,43,36,13,7]
     * Output: 54
     * Explanation: The pairs (i, j) that satisfy the conditions are:
     * - (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
     * - (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
     * So the maximum sum that we can obtain is 54.
     * Example 2:
     *
     * Input: nums = [10,12,19,14]
     * Output: -1
     * Explanation: There are no two numbers that satisfy the conditions, so we return -1.
     *
     *
     * */
    public static int maximumSum(int[] nums) {

        List<Integer> integers = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            int sumFirstNumber = sumOfNumber(nums[i]);
            for(int j = i + 1;j<nums.length;j++){
                int sumSecondNumber = sumOfNumber(nums[j]);
                if(sumFirstNumber == sumSecondNumber){
                    integers.add((nums[i]+nums[j]));
                }
            }
        }
        if(integers.isEmpty()) return -1;
        return integers.stream().min(Comparator.reverseOrder()).get();
    }
    public static int sumOfNumber(int n){
        int sum = 0;
        while(n != 0){
            int rem = n%10;
            sum += rem;
            n = n/10;
        }
        return sum;
    }

    public static int maximumSumLeetCodeSolution(int[] nums){
        int result = -1;
        int digitSum[] = new int[82];
        for(int i = 0;i<nums.length;i++){
            int sumOfDigits = sumOfNumber(nums[i]);
            if(digitSum[sumOfDigits] > 0)
                result = Math.max(result,(digitSum[sumOfDigits] + nums[i]));
            digitSum[sumOfDigits] = Math.max(digitSum[sumOfDigits],nums[i]);
        }
        return result;
    }
}
