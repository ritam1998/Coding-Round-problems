package leetcodeproblems.divideandconquer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(longestSubstring("ababbc",2));
    }
    /**
     * @Important
     * @395. Longest Substring with At Least K Repeating Characters
     * @https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/?envType=problem-list-v2&envId=divide-and-conquer
     *
     * Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
     *
     * if no such substring exists, return 0.
     *
     * Example 1:
     *
     * Input: s = "aaabb", k = 3
     * Output: 3
     * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
     * Example 2:
     *
     * Input: s = "ababbc", k = 2
     * Output: 5
     * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of only lowercase English letters.
     * 1 <= k <= 105
     * */
    public static int longestSubstring(String s, int k) {

        int n = s.length();

        if(n == 0 || n < k) return 0;

        if(k <= 1) return n;

        Map<Character,Integer> counts = new HashMap<>();
        for(char ch : s.toCharArray()) counts.put(ch,counts.getOrDefault(ch,0)+1);

        int length = 0;
        while ((length < n) && counts.get(s.charAt(length)) >= k) length++;
        if(length >= (n-1)) return length;

        int lengthSubString1 = longestSubstring(s.substring(0,length),k);
        while((length < n) && counts.get(s.charAt(length)) < k) length++;

        int lengthSubString2 = (length < n) ? longestSubstring(s.substring(length),k) : 0;

        return Math.max(lengthSubString1,lengthSubString2);
    }
}
