package leetcodeproblems.binarysearchproblems;

import java.util.Arrays;
import java.util.Optional;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
    /**
     * @Leetcode
     * @https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solutions/6605002/minimum-in-rotated-sorted-array-java-beats-100-solutions/?envType=problem-list-v2&envId=binary-search
     * @153. Find Minimum in Rotated Sorted Array
     *
     * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     *
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     *
     * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
     *
     * You must write an algorithm that runs in O(log n) time.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,4,5,1,2]
     * Output: 1
     * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
     * Example 2:
     *
     * Input: nums = [4,5,6,7,0,1,2]
     * Output: 0
     * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
     * Example 3:
     *
     * Input: nums = [11,13,15,17]
     * Output: 11
     * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     * */
    public static int findMin(int[] nums) {
        Optional<Integer> optionalInteger = Arrays.stream(nums).boxed().min(Integer::compare);
        return optionalInteger.orElse(0);
    }
    /**
     * @Leetcode Solution
     * */
    public static int findMin1(int[] nums) {
        int n = nums.length;
        int st = 0;
        int end = n - 1;
        int minIdx = 0;
        while(st <= end){
            int mid = st + (end - st) / 2;
            if(mid + 1 < n && nums[mid + 1] < nums[mid]) {
                minIdx = mid + 1;
                break;
            }
            if(nums[mid] < nums[n - 1]){
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return nums[minIdx];
    }
}
