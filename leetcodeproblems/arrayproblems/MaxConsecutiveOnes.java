package leetcodeproblems.arrayproblems;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
    /**
     * @Leetcode
     * @485. Max Consecutive Ones
     * @https://leetcode.com/problems/max-consecutive-ones/description/?envType=problem-list-v2&envId=array
     *
     * Given a binary array nums, return the maximum number of consecutive 1's in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,0,1,1,1]
     * Output: 3
     * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
     * Example 2:
     *
     * Input: nums = [1,0,1,1,0,1]
     * Output: 2
     * */
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result = 0,count = 0;
        for(int data : nums){
            count = data == 1? count+1 : 0;
            result = Math.max(result,count);
        }
        return result;
    }
}
