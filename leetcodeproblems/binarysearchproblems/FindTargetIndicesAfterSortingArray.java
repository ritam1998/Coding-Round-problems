package leetcodeproblems.binarysearchproblems;

import java.util.*;

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1,2,5,2,3},2));
    }
    /**
     * @Leetcode
     * @2089. Find Target Indices After Sorting Array
     * @https://leetcode.com/problems/find-target-indices-after-sorting-array/description/?envType=problem-list-v2&envId=binary-search
     *
     * You are given a 0-indexed integer array nums and a target element target.
     *
     * A target index is an index i such that nums[i] == target.
     *
     * Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,5,2,3], target = 2
     * Output: [1,2]
     * Explanation: After sorting, nums is [1,2,2,3,5].
     * The indices where nums[i] == 2 are 1 and 2.
     * Example 2:
     *
     * Input: nums = [1,2,5,2,3], target = 3
     * Output: [3]
     * Explanation: After sorting, nums is [1,2,2,3,5].
     * The index where nums[i] == 3 is 3.
     * Example 3:
     *
     * Input: nums = [1,2,5,2,3], target = 5
     * Output: [4]
     * Explanation: After sorting, nums is [1,2,2,3,5].
     * The index where nums[i] == 5 is 4.
     * */
    public static List<Integer> targetIndices(int[] nums, int target) {

        Arrays.sort(nums);
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        Optional<Map.Entry<Integer,List<Integer>>> optional = map.entrySet()
                .stream()
                .filter(k -> k.getKey()==target)
                .findFirst();

        return optional.map(Map.Entry::getValue).orElse(new ArrayList<>());
    }
}
