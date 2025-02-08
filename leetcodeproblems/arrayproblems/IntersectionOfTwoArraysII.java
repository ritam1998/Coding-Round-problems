package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
    /**
     * @LeetCode
     * @350. Intersection of Two Arrays II
     * @Important
     * @https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
     * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Explanation: [9,4] is also accepted.
     * */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> integers = new ArrayList<>();

        while ((i < nums1.length) && (j < nums2.length)){
            if(nums1[i] < nums2[j]) i++;
            else if(nums1[i] > nums2[j]) j++;
            else{
                integers.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] array = new int[integers.size()];
        for(int k = 0;k<integers.size();k++) array[k] = integers.get(k);

        return array;
    }
}
