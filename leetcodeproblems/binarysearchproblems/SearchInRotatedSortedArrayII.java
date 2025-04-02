package leetcodeproblems.binarysearchproblems;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,0,1,1,1},0));
    }
    /**
     * @Leetcode
     * @https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/?envType=problem-list-v2&envId=binary-search
     * @81. Search in Rotated Sorted Array II
     *
     * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
     *
     * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
     *
     * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
     *
     * You must decrease the overall operation steps as much as possible.
     *
     *
     * Example 1:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     * Example 2:
     *
     * Input: nums = [2,5,6,0,0,1,2], target = 3
     * Output: false
     * */
    public static boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        return binarySearch(nums, target, 0, nums.length - 1) != -1;
    }
    public static int binarySearch(int[] num,int target,int start,int end){
        if(start <= end){
            int mid = start + (end - start) / 2;
            if(num[mid] == target)
                return mid;
            else if(num[mid] < target)
                return binarySearch(num,target,mid+1,end);
            else
                return binarySearch(num,target,start,mid-1);
        }
        return -1;
    }
}
