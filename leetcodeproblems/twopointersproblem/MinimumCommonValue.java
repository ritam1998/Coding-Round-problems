package leetcodeproblems.twopointersproblem;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumCommonValue {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1,2,3,6},new int[]{2,3,4,5}));
    }
    /**
     * @LeetCode
     * @2540. Minimum Common Value
     * @https://leetcode.com/problems/minimum-common-value/description/?envType=problem-list-v2&envId=two-pointers
     *
     * Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
     *
     * Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of that integer.
     *
     *
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,3], nums2 = [2,4]
     * Output: 2
     * Explanation: The smallest element common to both arrays is 2, so we return 2.
     * Example 2:
     *
     * Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
     * Output: 2
     * Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
     * */
    public static int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        set.retainAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        return set.stream().min(Integer::compare).orElse(0);
    }
    public static int getCommon2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        // Add the elements from nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Search for each element of nums2 in set1
        // Return the first common element found
        for (int num : nums2) {
            if (set1.contains(num)) {
                return num;
            }
        }

        // Return -1 if there are no common elements
        return -1;
    }
}
