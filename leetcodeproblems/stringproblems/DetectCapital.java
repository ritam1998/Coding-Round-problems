package leetcodeproblems.stringproblems;

import java.util.ArrayList;
import java.util.List;

public class DetectCapital {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("ffffffffffffffffffffF"));
    }
    /**
     * @LeetCode
     * @520. Detect Capital
     * @https://leetcode.com/problems/detect-capital/description/
     * We define the usage of capitals in a word to be right when one of the following cases holds:
     *
     * All letters in this word are capitals, like "USA".
     * All letters in this word are not capitals, like "leetcode".
     * Only the first letter in this word is capital, like "Google".
     * Given a string word, return true if the usage of capitals in it is right.
     *
     *
     * Example 1:
     *
     * Input: word = "USA"
     * Output: true
     * Example 2:
     *
     * Input: word = "FlaG"
     * Output: false
     * */
    public static boolean detectCapitalUse(String word) {

        int upper = 0, lower = 0;
        boolean f = false;
        for(int i = 0;i<word.length();i++){
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') upper ++;
            else lower ++;
        }
        if(upper == 1 && lower == word.length()-1 && Character.isUpperCase(word.charAt(0))) f = true;
        else if(upper == word.length()) f = true;
        else if(lower == word.length()) f = true;

        return f;
    }
}
