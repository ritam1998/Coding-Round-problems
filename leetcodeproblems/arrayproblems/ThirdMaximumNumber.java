package leetcodeproblems.arrayproblems;

import java.util.*;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2,2,3,1}));
    }
    /**
     * @Leetcode
     * @Important
     * @414. Third Maximum Number
     * @https://leetcode.com/problems/third-maximum-number/description/
     *
     * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2.
     * The third distinct maximum is 1.
     * Example 2:
     *
     * Input: nums = [1,2]
     * Output: 2
     * Explanation:
     * The first distinct maximum is 2.
     * The second distinct maximum is 1.
     * The third distinct maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     *
     * Input: nums = [2,2,3,1]
     * Output: 1
     * Explanation:
     * The first distinct maximum is 3.
     * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
     * The third distinct maximum is 1.
     * */
    public static int thirdMax(int[] nums) {

        int[] sortedArray = Arrays.stream(nums)
                .boxed()
                .distinct()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .mapToInt(i->i)
                .toArray();

        int previousElement = sortedArray[0];
        int elementCount = 1;

        for(int i = 1;i<sortedArray.length;i++){
            if(sortedArray[i] != previousElement){
                elementCount += 1;
                previousElement = sortedArray[i];
            }
            if(elementCount == 3) return sortedArray[i];
        }
        return sortedArray[0];
    }
}
