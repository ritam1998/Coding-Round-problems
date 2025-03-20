package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.stream.Collectors;

public class SortThePeople {
    public static void main(String[] args) {
        System.out.println(sortPeople(new String[]{"Mary","John","Emma"},new int[]{180,165,170}));
    }
    /**
     * @leetCode
     * @2418. Sort the People
     * @https://leetcode.com/problems/sort-the-people/description/
     *
     * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
     *
     * For each index i, names[i] and heights[i] denote the name and height of the ith person.
     *
     * Return names sorted in descending order by the people's heights.
     *
     * Example 1:
     *
     * Input: names = ["Mary","John","Emma"], heights = [180,165,170]
     * Output: ["Mary","Emma","John"]
     * Explanation: Mary is the tallest, followed by Emma and John.
     * Example 2:
     *
     * Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
     * Output: ["Bob","Alice","Bob"]
     * Explanation: The first Bob is the tallest, followed by Alice and the second Bob.
     * */
    public static String[] sortPeople(String[] names, int[] heights) {

        Map<Integer,String> mapHeightToNames = new HashMap<>();
        for(int i = 0;i<heights.length;i++) mapHeightToNames.put(heights[i],names[i]);

        List<Integer> sortedKeys = mapHeightToNames.keySet().stream().sorted().collect(Collectors.toList());
        List<String> results = new ArrayList<>();
        for(int i = sortedKeys.size()-1;i>=0;i--) results.add(mapHeightToNames.get(sortedKeys.get(i)));

        return results.toArray(String[]::new);
    }
}
