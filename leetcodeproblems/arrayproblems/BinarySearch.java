package leetcodeproblems.arrayproblems;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }
    public static int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }
    /**
     * @704. Binary Search
     * @https://leetcode.com/problems/binary-search/description/
     *
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     *
     * Example 1:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 9
     * Output: 4
     * Explanation: 9 exists in nums and its index is 4
     * Example 2:
     *
     * Input: nums = [-1,0,3,5,9,12], target = 2
     * Output: -1
     * Explanation: 2 does not exist in nums so return -1
     * */
    public static int binarySearch(int[] nums, int target,int start,int end){

        if(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                return binarySearch(nums,target,mid+1,end);
            else
                return binarySearch(nums,target,start,mid-1);
        }
        return -1;
    }
}
