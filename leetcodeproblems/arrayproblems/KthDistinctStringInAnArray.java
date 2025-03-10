package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"},2));
    }
    /**
     * @2053. Kth Distinct String in an Array
     * @https://leetcode.com/problems/kth-distinct-string-in-an-array/description/
     *
     * A distinct string is a string that is present only once in an array.
     *
     * Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".
     *
     * Note that the strings are considered in the order in which they appear in the array.
     *
     * Example 1:
     *
     * Input: arr = ["d","b","c","b","c","a"], k = 2
     * Output: "a"
     * Explanation:
     * The only distinct strings in arr are "d" and "a".
     * "d" appears 1st, so it is the 1st distinct string.
     * "a" appears 2nd, so it is the 2nd distinct string.
     * Since k == 2, "a" is returned.
     * Example 2:
     *
     * Input: arr = ["aaa","aa","a"], k = 1
     * Output: "aaa"
     * Explanation:
     * All strings in arr are distinct, so the 1st string "aaa" is returned.
     * Example 3:
     *
     * Input: arr = ["a","b","a"], k = 3
     * Output: ""
     * Explanation:
     * The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
     * */
    public static String kthDistinct(String[] arr, int k) {

        Map<String,Long> m = Arrays.stream(arr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldOne,newOne) -> oldOne, LinkedHashMap::new));

        for (String s : arr) {
            if (m.get(s) == 1) k--;
            if(k == 0) return s;
        }
        return "";
    }
}
