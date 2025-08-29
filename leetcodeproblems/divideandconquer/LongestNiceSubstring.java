package leetcodeproblems.divideandconquer;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        System.out.println(longestNiceSubstring("YazaAay"));
    }
    /**
     * @Leetcode
     * @Important
     * @1763. Longest Nice Substring
     * @https://leetcode.com/problems/longest-nice-substring/description/?envType=problem-list-v2&envId=divide-and-conquer
     *
     * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear.
     * However, "abA" is not because 'b' appears, but 'B' does not.
     *
     * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
     *
     *
     * Example 1:
     *
     * Input: s = "YazaAay"
     * Output: "aAa"
     * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
     * "aAa" is the longest nice substring.
     * Example 2:
     *
     * Input: s = "Bb"
     * Output: "Bb"
     * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
     * Example 3:
     *
     * Input: s = "c"
     * Output: ""
     * Explanation: There are no nice substrings.
     * */
    public static String longestNiceSubstring(String s) {

        if (s.length() < 2) return "";

        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) charSet.add(c);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check if the character's counterpart exists in the set
            if (!charSet.contains(Character.toLowerCase(c)) || !charSet.contains(Character.toUpperCase(c))) {

                // If a "bad" character is found, split the string and recurse
                String sub1 = longestNiceSubstring(s.substring(0, i));
                String sub2 = longestNiceSubstring(s.substring(i + 1));

                // Return the longer of the two results
                return sub1.length() >= sub2.length() ? sub1 : sub2;
            }
        }

        // If the loop completes, the entire string is nice
        return s;
    }
}
