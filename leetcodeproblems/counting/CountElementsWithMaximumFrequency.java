package leetcodeproblems.counting;

import java.util.*;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{17,17,2,12,20,17,12}));
    }
    /**
     * @3005. Count Elements With Maximum Frequency
     * @https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=problem-list-v2&envId=counting
     *
     * You are given an array nums consisting of positive integers.
     *
     * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
     *
     * The frequency of an element is the number of occurrences of that element in the array.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,2,3,1,4]
     * Output: 4
     * Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
     * So the number of elements in the array with maximum frequency is 4.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: 5
     * Explanation: All elements of the array have a frequency of 1 which is the maximum.
     * So the number of elements in the array with maximum frequency is 5.
     * */
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> integerMap = new HashMap<>();
        int duplicateCount = 0, nonDuplicateCount = 0, maxFreq = 0;
        for(int i = 0;i<nums.length;i++) integerMap.put(nums[i],integerMap.getOrDefault(nums[i],0)+1);
        for(Map.Entry<Integer,Integer> map : integerMap.entrySet()){
            maxFreq = Math.max(maxFreq,map.getValue());
        }
        for(Integer frequency : integerMap.values()){
            if(maxFreq == frequency) duplicateCount++;
        }
        return duplicateCount * maxFreq;
    }
}
