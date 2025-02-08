package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
    /**
     * @Leetcode
     * @349. Intersection of Two Arrays
     * @https://leetcode.com/problems/intersection-of-two-arrays/description/
     *
     * Given two integer arrays nums1 and nums2, return an array of their
     * intersection
     * . Each element in the result must be unique and you may return the result in any order.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [9,4]
     * Explanation: [4,9] is also accepted.
     * */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> integerSet1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> integerSet2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        integerSet1.retainAll(integerSet2);
        List<Integer> integers = new ArrayList<>(integerSet1);

        int[] array = new int[integers.size()];
        for(int i = 0;i<integers.size();i++) array[i] = integers.get(i);

        return array;
    }
}
