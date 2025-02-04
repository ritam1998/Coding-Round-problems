package leetcodeproblems.stringproblems;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
    /**
     * @Important
     * @Leetcode
     * @392. Is Subsequence
     * @https://leetcode.com/problems/is-subsequence/description/
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     *
     * Example 1:
     *
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * Example 2:
     *
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     * */
    public static boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;
        while(j < t.length()){
            if((i < s.length()) && (s.charAt(i) == t.charAt(j))){
                i = i + 1;
            }
            j = j + 1;
        }
        return i == s.length();
    }
}
