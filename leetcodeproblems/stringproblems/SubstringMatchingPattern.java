package leetcodeproblems.stringproblems;

public class SubstringMatchingPattern {
    public static void main(String[] args) {
        hasMatch("leetcode","ee*e");
    }
    /**
     * @Leetcode
     * @Important
     * @3407. Substring Matching Pattern
     * @https://leetcode.com/problems/substring-matching-pattern/description/
     *
     * You are given a string s and a pattern string p, where p contains exactly one '*' character.
     *
     * The '*' in p can be replaced with any sequence of zero or more characters.
     *
     * Return true if p can be made a substring of s, and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "leetcode", p = "ee*e"
     *
     * Output: true
     *
     * Explanation:
     *
     * By replacing the '*' with "tcod", the substring "eetcode" matches the pattern.
     *
     * Example 2:
     *
     * Input: s = "car", p = "c*v"
     *
     * Output: false
     *
     * Explanation:
     *
     * There is no substring matching the pattern.
     *
     * Example 3:
     *
     * Input: s = "luck", p = "u*"
     *
     * Output: true
     *
     * Explanation:
     *
     * The substrings "u", "uc", and "uck" match the pattern.
     * */
    public static boolean hasMatch(String s, String p) {

        int starIndexOf = p.indexOf("*");
        System.out.println(starIndexOf);

        int leftIndex = s.indexOf(p.substring(0,starIndexOf));
        System.out.println(leftIndex);

        int secondIndexOf = leftIndex + p.substring(0,starIndexOf).length();
        System.out.println(secondIndexOf);

        String temp = s.substring(secondIndexOf);
        System.out.println(temp);

        int rightIndexOf = temp.indexOf(p.substring(starIndexOf+1));
        System.out.println(rightIndexOf);

        return leftIndex != -1 && rightIndexOf != -1;
    }
}
