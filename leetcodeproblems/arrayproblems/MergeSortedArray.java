package leetcodeproblems.arrayproblems;

import java.util.Arrays;


/**
 *
 * @88. Merge Sorted Array
 * @https://leetcode.com/problems/merge-sorted-array/description/?envType=problem-list-v2&envId=array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 *
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * */
public class MergeSortedArray {
    public static void main(String[] args) {
        int [] mergedArray = merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
        Arrays.stream(mergedArray).forEach(System.out::println);
    }
    /**
     * @Algorithm
     *
     * The algorithm provided in the `merge` method is an in-place merging technique for two sorted arrays. It's designed to merge `nums2` into `nums1`,
     * assuming `nums1` has enough space at the end to accommodate all elements from `nums2`.
     *
     * ### **Algorithm**
     * The algorithm works by merging the two arrays from the **end to the beginning**. This approach is crucial because it prevents overwriting the smaller,
     * unmerged elements in `nums1` as you place the larger elements from either array into their final positions.
     *
     * 1.  **Initialize Pointers**:
     *     * A pointer `last` is initialized to the last index of the merged array (`m + n - 1`).
     *     * A pointer `m` points to the last element of the first array `nums1` to be considered (`m-1` is the index).
     *     * A pointer `n` points to the last element of the second array `nums2` to be considered (`n-1` is the index).
     *
     * 2.  **Reverse Merging Loop**:
     *     * A `while` loop continues as long as there are elements left to compare in both `nums1` and `nums2` (`m > 0` and `n > 0`).
     *     * Inside the loop, compare the elements at the current pointers of both arrays: `nums1[m - 1]` and `nums2[n - 1]`.
     *     * The larger of the two elements is placed at the current `last` position in `nums1`.
     *     * The pointer of the array from which the element was taken is decremented (`m--` or `n--`).
     *     * The `last` pointer is always decremented (`last--`) to move to the next position.
     *
     *
     *
     * 3.  **Handle Remaining Elements**:
     *     * After the main loop finishes, one of the arrays might still have elements that haven't been placed. This will only ever be `nums2`,
     *     because if there were remaining elements in `nums1`, they would be in their correct, final positions anyway since they are smaller than all the elements in `nums2` that have already been placed.
     *     * A second `while` loop checks if there are any remaining elements in `nums2` (`n > 0`).
     *     * If so, these elements are simply copied into the remaining space at the beginning of `nums1`.
     *
     * 4.  **Return**:
     *     * The function returns the modified `nums1` array, which now contains all the merged and sorted elements.
     * */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int last = m + n - 1;
        // merge in reverse order
        while( (n > 0) && (m > 0) ){
            if(nums1[m - 1] < nums2[n-1]){
                nums1[last] = nums2[n - 1];
                n--;
            }
            else {
                nums1[last] = nums1[m - 1];
                m--;
            }
            last--;
        }
        // fill num1 with left over num2 elements
        while(n > 0){
            nums1[last] = nums2[n - 1];
            last--;
            n--;
        }
        return nums1;
    }
}
