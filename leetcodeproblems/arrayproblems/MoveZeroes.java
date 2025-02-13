package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0});
    }
    /**
     * @leetcode
     * @important
     * @283. Move Zeroes
     * @https://leetcode.com/problems/move-zeroes/description/
     *
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     *
     * Example 1:
     *
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     *
     * Input: nums = [0]
     * Output: [0]
     * */
    public static void moveZeroes(int[] nums) {

        List<Integer> list = new ArrayList<>();
        List<Integer> withZeros = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            if(nums[i] != 0) list.add(nums[i]);
            else withZeros.add(nums[i]);
        }

        if(list.size() > 0){
            for(int i = 0;i<nums.length;i++) nums[i] = list.get(i);
        }


        System.out.println(nums);
    }
}
