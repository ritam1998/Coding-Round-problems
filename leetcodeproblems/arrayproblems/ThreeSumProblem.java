package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSumProblem {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
    /**
     * @Leetcode
     * @Important
     * @15. 3Sum
     * @https://leetcode.com/problems/3sum/description/
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     * Example 1:
     *
     * Input: nums = [-1,0,1,2,-1,-4]
     * Output: [[-1,-1,2],[-1,0,1]]
     * Explanation:
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
     * The distinct triplets are [-1,0,1] and [-1,-1,2].
     * Notice that the order of the output and the order of the triplets does not matter.
     * Example 2:
     *
     * Input: nums = [0,1,1]
     * Output: []
     * Explanation: The only possible triplet does not sum up to 0.
     * Example 3:
     *
     * Input: nums = [0,0,0]
     * Output: [[0,0,0]]
     * Explanation: The only possible triplet sums up to 0.
     * */
    public static List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> lists = new ArrayList<>();

        /**
         * I initialized a loop from 0 to n, setting j to i + 1 for the next index and k to the array's last index. Within the loop, I checked if j was less than k.
         * If so, I calculated the sum of elements at indices i, j, and k. If the sum equaled the target, I incremented j, decremented k, and added the three numbers to the list. Otherwise, if the sum was less than the target, I incremented j; otherwise, I decremented k."
         * Here's a breakdown of the changes:
         *  * "while if j < k" changed to "if j was less than k": This is more grammatically correct and concise.
         *  * "j++" changed to "incremented j": While "j++" is common in programming, it's less common in general writing.
         *  * "else if I checked sum < target then j++ or else k--" changed to "if the sum was less than the target, I incremented j; otherwise, I decremented k.": This is more grammatically correct and easier to read.
         * The corrected sentence is clearer and more concise while still conveying the same information.
         * */

        for(int i = 0;i<nums.length;i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    set.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }else if(sum < target) j++;
                else k--;
            }
        }
        lists.addAll(set);
        return lists;
    }
}
