package leetcodeproblems.arrayproblems;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[]{1,7,9,2,5},11,11));
    }
    /**
     * @Important
     * @2563. Count the Number of Fair Pairs
     * @https://leetcode.com/problems/count-the-number-of-fair-pairs/description/?envType=daily-question&envId=2025-04-19
     *
     * Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.
     *
     * A pair (i, j) is fair if:
     *
     * 0 <= i < j < n, and
     * lower <= nums[i] + nums[j] <= upper
     *
     *
     * Example 1:
     *
     * Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
     * Output: 6
     * Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
     * Example 2:
     *
     * Input: nums = [1,7,9,2,5], lower = 11, upper = 11
     * Output: 1
     * Explanation: There is a single fair pair: (2,3).
     *
     * */
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                int sum = nums[i] + nums[j];
                if(sum <= upper && sum >= lower){
                    count++;
                }
            }
        }
        return count;
    }
    static long lower_bound(int[] nums, int low, int high, int element) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * @Leetcode solution using binary search approach
     * */
    public static long countFairPairs2(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            // Assume we have picked nums[i] as the first pair element.

            // `low` indicates the number of possible pairs with sum < lower.
            long low = lower_bound(
                    nums,
                    i + 1,
                    nums.length - 1,
                    lower - nums[i]
            );

            // `high` indicates the number of possible pairs with sum <= upper.
            long high = lower_bound(
                    nums,
                    i + 1,
                    nums.length - 1,
                    upper - nums[i] + 1
            );

            // Their difference gives the number of elements with sum in the
            // given range.
            ans += 1 * (high - low);
        }
        return ans;
    }
}
