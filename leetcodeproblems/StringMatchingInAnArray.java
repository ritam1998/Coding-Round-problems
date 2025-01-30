package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringMatchingInAnArray {
    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }
    /**
     * @LeetCODE
     * @1408.String Matching in an Array
     * @https://leetcode.com/problems/string-matching-in-an-array/description/
     * Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.
     *
     * A substring is a contiguous sequence of characters within a string
     *
     * Example 1:
     *
     * Input: words = ["mass","as","hero","superhero"]
     * Output: ["as","hero"]
     * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
     * ["hero","as"] is also a valid answer.
     * Example 2:
     *
     * Input: words = ["leetcode","et","code"]
     * Output: ["et","code"]
     * Explanation: "et", "code" are substring of "leetcode".
     * Example 3:
     *
     * Input: words = ["blue","green","bu"]
     * Output: []
     * Explanation: No string of words is substring of another string.
     * */
    public static List<String> stringMatching(String[] words) {
        Set<String> stringList = new HashSet<>();
        for(int i =0;i<words.length;i++){
            for(int j = 0;j< words.length;j++){
                if(!words[i].equalsIgnoreCase(words[j])){
                    if(words[j].contains(words[i])){
                        stringList.add(words[i]);
                    }
                }
            }
        }
        return new ArrayList<>(stringList);
    }
}
