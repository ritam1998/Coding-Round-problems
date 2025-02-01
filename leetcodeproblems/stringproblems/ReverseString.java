package leetcodeproblems.stringproblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseString {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l','o'});
    }
    /**
     * @Leetcode
     * @344. Reverse String
     * @https://leetcode.com/problems/reverse-string/description/
     * Write a function that reverses a string. The input string is given as an array of characters s.
     *
     * You must do this by modifying the input array in-place with O(1) extra memory.
     *
     * Example 1:
     *
     * Input: s = ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: s = ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     * */
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j){
            char temp = s[i];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }
}
