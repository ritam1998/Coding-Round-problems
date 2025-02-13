package leetcodeproblems.stringproblems;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
    /**
     * @LeetCode
     * @Important
     * @205. Isomorphic Strings
     * @https://leetcode.com/problems/isomorphic-strings/description/
     *
     * Given two strings s and t, determine if they are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     *
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
     *
     * Example 1:
     *
     * Input: s = "egg", t = "add"
     * Output: true
     *
     * Explanation:
     *
     * The strings s and t can be made identical by:
     *
     * Mapping 'e' to 'a'.
     * Mapping 'g' to 'd'.
     * Example 2:
     *
     * Input: s = "foo", t = "bar"
     * Output: false
     *
     * Explanation:
     *
     * The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.
     *
     * Example 3:
     *
     * Input: s = "paper", t = "title"
     * Output: true
     * */
    public static boolean isIsomorphic(String s, String t) {

        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        if((s.length() == 0) && (t.length() == 0)) return true;

        Map<Character,Character> characterMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            Character ch = getKey(characterMap,t1);
            if(ch != null && ch != s1) return false;
            else if(characterMap.containsKey(s1)){
                if(t1 != characterMap.get(s1)) return false;
            }
            characterMap.put(s1,t1);
        }
        return true;
    }
    public static Character getKey(Map<Character,Character> map,Character target){
        for(Map.Entry<Character,Character> m : map.entrySet()){
            if(m.getValue().equals(target))
                return m.getKey();
        }
        return null;
    }
}
