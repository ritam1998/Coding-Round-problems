package leetcodeproblems.stringproblems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
    }
    /**
     * @Important
     * @Leetcode
     * @1358. Number of Substrings Containing All Three Characters
     * @https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/?envType=daily-question&envId=2025-03-11
     *
     * Given a string s consisting only of characters a, b and c.
     *
     * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
     *
     * Example 1:
     *
     * Input: s = "abcabc"
     * Output: 10
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
     * Example 2:
     *
     * Input: s = "aaacb"
     * Output: 3
     * Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
     * Example 3:
     *
     * Input: s = "abc"
     * Output: 1
     * */
    public static int numberOfSubstrings(String s) {

        int left = 0;
        int ans = 0;
        Map<Character,Integer> seen = new HashMap<>();
        for(int right = 0;right < s.length();right++){
            char ch = s.charAt(right);

            /**
             * {@Step-1} check the character in hashmap is present or not.
             * If it is present it will increment the number
             * */
            seen.put(ch,seen.getOrDefault(ch,0)+1);

            /**
             * {@Step-2} Where I am checking if hashmap size is equal to 3
             * {@Step-3} where we just sub struct the string length and the index.
             * Example: the string length is s.length = 6; and index is 2. So, the ans is 4.
             *
             * {@Step-4} then we found the almost left character.
             * {@Step-5} if we found in hashmap then we are reducing the number.
             * Example: seen.put(leftChar,seen.get(leftChar)-1);
             *
             *
             * */
            while (seen.size() == 3){
                ans += s.length()-right;
                char leftChar = s.charAt(left);
                seen.put(leftChar,seen.get(leftChar)-1);
                /**
                 * {@Step-6} if the left character is equals to 0 and removed the left chars.
                 * */
                if(seen.get(leftChar) == 0) seen.remove(leftChar);
                left++;
            }
        }
        return ans;
    }
}
