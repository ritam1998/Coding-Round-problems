package leetcodeproblems.stringproblems;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
    /**
     * @Leetcode
     * @Important
     * @5. Longest Palindromic Substring
     * @https://leetcode.com/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=two-pointers
     *
     * Given a string s, return the longest palindromic substring in s.
     *
     * Example 1:
     *
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cbbd"
     * Output: "bb"
     * */
    public static String longestPalindrome(String s) {

        if(s.length() <= 1) return s;

        String lps = "";
        for(int i = 1;i<s.length();i++){

            // consider for odd length
            int left = i;
            int right = i;
            while(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                if(left == -1 || right == s.length()) break;
            }
            String palindrome = s.substring(left+1,right);
            if(palindrome.length() > lps.length()) lps = palindrome;

            // consider for even length
            left = i -1;
            right = i;
            while(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                if(left == -1 || right == s.length()) break;
            }
            palindrome = s.substring(left+1,right);
            if(palindrome.length() > lps.length()) lps = palindrome;
        }
        return lps;
    }
}
