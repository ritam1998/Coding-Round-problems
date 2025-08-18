package leetcodeproblems.divideandconquer;

import java.util.Arrays;

/**
 * @215. Kth Largest Element in an Array
 * @https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 * */
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSelectAlgorithm(nums,0,nums.length - 1,nums.length - k);
    }
    public static int findKthLargestSecondApproach(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];     }
    /**
     *
     * @Algorithm
     * The QuickSelect algorithm works as follows:
     *
     * Select a Pivot: Choose an element from the array to be the pivot. The code uses the last element of the current sub-array array[right] as the pivot.
     *
     * Partition: Rearrange the sub-array so that all elements smaller than or equal to the pivot are on its left, and all elements greater than the pivot are on its right.
     * The goal is to find the correct sorted position for the pivot.
     *
     * Compare and Recurse:
     *
     * After partitioning, the pivot is at a specific index p. This index p represents the final sorted position of the pivot.
     *
     * Compare p with the target index k (which is nums.length - k for the k
     * th
     *   largest element):
     *
     * If p > k, the k
     * th
     *   element is in the left sub-array, so the algorithm recursively searches in the left half.
     *
     * If p < k, the k
     * th
     *   element is in the right sub-array, so the algorithm recursively searches in the right half.
     *
     * If p = k, the pivot itself is the k
     * th
     *   element, and it is returned.
     *
     * The provided code calculates the target index as nums.length - k to find the k
     * th
     *   largest element. For the input {3,2,1,5,6,4} and k=2, it searches for the 2
     * nd
     *   largest element, which is 5. This corresponds to the index 6-2 = 4 if the array were sorted. The algorithm correctly finds the element at this index.
     *
     * Code Correction
     * The quickSelectAlgorithm method in the provided code has a logical error in its for loop and the subsequent swap.
     * The lines array[p] = array[i]; array[i] = array[p]; do not correctly swap elements.
     * This is a common mistake and results in array[i] being assigned to array[p] twice, effectively not performing a swap. A proper swap requires a temporary variable.
     * */
    public static int quickSelectAlgorithm(int[] array,int left,int right,int k){

        int pivotElement = array[right];
        int p = left;

        if (left == right) return array[left];

        for(int i = left;i<=right;i++){
            if(array[i] <= pivotElement){
                int temp = array[p];
                array[p] = array[i];
                array[i] = temp;
                p++;
            }
        }
        int temp = array[p];
        array[p] = array[right];
        array[right] = temp;

        if(p > k) return quickSelectAlgorithm(array,left,p - 1,k);
        else if(p < k) return quickSelectAlgorithm(array,p + 1,right,k);
        else return array[p];
    }
}
