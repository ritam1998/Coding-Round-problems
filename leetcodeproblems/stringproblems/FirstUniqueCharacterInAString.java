package leetcodeproblems.stringproblems;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("loveleetcode"));
    }
    /**
     * @Important
     * @Leetcode
     * @387. First Unique Character in a String
     * @https://leetcode.com/problems/first-unique-character-in-a-string/description/
     * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
     *
     * Example 1:
     *
     * Input: s = "leetcode"
     * Output: 0
     *
     * Explanation:
     *
     * The character 'l' at index 0 is the first character that does not occur at any other index.
     *
     * Example 2:
     *
     * Input: s = "loveleetcode"
     * Output: 2
     *
     * Example 3:
     *
     * Input: s = "aabb"
     * Output: -1
     * */
    public static int firstUniqueChar(String s) {
        for(int j = 0;j<s.length();j++){
            if(s.indexOf(s.charAt(j)) == s.lastIndexOf(s.charAt(j))) return j;
        }
        return -1;
    }
}
