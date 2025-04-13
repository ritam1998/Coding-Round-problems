package leetcodeproblems.arrayproblems;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{3,-1,4}));
    }
    /**
     * @Leetcode
     * @152. Maximum Product Sub-array
     * @https://leetcode.com/problems/maximum-product-subarray/description/?source=submission-noac
     *
     * Given an integer array nums, find a subarray that has the largest product, and return the product.
     *
     * The test cases are generated so that the answer will fit in a 32-bit integer.
     *
     *
     * Example 1:
     *
     * Input: nums = [2,3,-2,4]
     * Output: 6
     * Explanation: [2,3] has the largest product 6.
     * Example 2:
     *
     * Input: nums = [-2,0,-1]
     * Output: 0
     * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
     * */
    public static int maxProduct(int[] nums) {

        int result = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int maxProduct = 1;
            for(int j = i;j<nums.length;j++){
                maxProduct *= nums[j];
                result = Math.max(result,maxProduct);
            }
        }
        return result;
    }
}
