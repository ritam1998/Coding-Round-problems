package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }
    /**
     * @LeetCode
     * @Important
     * @46. Permutations
     * @https://leetcode.com/problems/permutations/description/
     *
     * Given an array nums of distinct integers, return all the possible
     * permutations
     * . You can return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * Example 3:
     *
     * Input: nums = [1]
     * Output: [[1]]
     * */
    public static List<List<Integer>> permute(int[] nums) {
        Set<List<Integer>> results = new HashSet<>();
        permutation(nums,0,results);
        return new ArrayList<>(results);
    }
    public static void permutation(int[] nums,int start, Set<List<Integer>> results){
        if(start == nums.length - 1) results.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        else{
            for(int i = 0;i<nums.length;i++){
                swap(nums,start,i);
                permutation(nums,start+1,results);
                swap(nums,start,i);
            }
        }
    }
    public static void swap(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
