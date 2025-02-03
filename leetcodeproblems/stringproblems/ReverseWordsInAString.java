package leetcodeproblems.stringproblems;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    /**
     * @Leetcode
     * @557. Reverse Words in a String III
     * @https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
     * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     *
     * Example 1:
     *
     * Input: s = "Let's take LeetCode contest"
     * Output: "s'teL ekat edoCteeL tsetnoc"
     * Example 2:
     *
     * Input: s = "Mr Ding"
     * Output: "rM gniD"
     * */
    public static String reverseWords(String s) {

        String[] words = s.split(" ");
        Function<String,String> stringFunction = value -> {
          String str = "";
          for(int i = value.length()-1;i >= 0;i--)
              str += value.charAt(i);
          return str;
        };
        return Arrays.stream(words).map(stringFunction).collect(Collectors.joining(" "));
    }
}
