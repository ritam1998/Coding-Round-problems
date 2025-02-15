package leetcodeproblems.arrayproblems;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        sortedSquares(new int[]{-4,-1,0,3,10});
    }
    /**
     * @Leetcode
     * @977. Squares of a Sorted Array
     * @https://leetcode.com/problems/squares-of-a-sorted-array/description/
     *
     * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
     *
     * Example 1:
     *
     * Input: nums = [-4,-1,0,3,10]
     * Output: [0,1,9,16,100]
     * Explanation: After squaring, the array becomes [16,1,0,9,100].
     * After sorting, it becomes [0,1,9,16,100].
     * Example 2:
     *
     * Input: nums = [-7,-3,2,3,11]
     * Output: [4,9,9,49,121]
     * */
    public static int[] sortedSquares(int[] nums) {

        int[] integerList = Arrays.stream(nums)
                .boxed()
                .map(m -> m*m)
                .sorted((a,b) -> a - b)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(integerList);

        return null;
    }
}
