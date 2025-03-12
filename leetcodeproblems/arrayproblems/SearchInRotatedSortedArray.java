package leetcodeproblems.arrayproblems;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
    }
    /**
     * @Medium
     * @Important
     * @33. Search in Rotated Sorted Array
     * @https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     *
     * There is an integer array nums sorted in ascending order (with distinct values).
     *
     * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
     * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
     *
     * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 3
     * Output: -1
     * Example 3:
     *
     * Input: nums = [1], target = 0
     * Output: -1
     * */
    public static int search(int[] nums, int target) {
        return searchIndex(nums,target,0,nums.length-1);
    }
    public static int searchIndex(int[] num,int target,int start,int end){
        if(start <= end){
            int mid = start + (end - start)/2;
            if(num[mid] == target)
                return mid;
            if(num[start] <= num[mid]){
                if((num[start] <= target) && (target < num[mid]))
                    return searchIndex(num,target,start,mid-1);
                else
                    return searchIndex(num,target,mid+1,end);
            }else{
                if((num[mid] < target) && (target <= num[end]))
                    return searchIndex(num,target,mid+1,end);
                else
                    return searchIndex(num,target,start,end-1);
            }
        }
        return -1;
    }
}
