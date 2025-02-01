package leetcodeproblems.stringproblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    /**
     * @Leetcode
     * @Important
     * @14. Longest Common Prefix
     * @https://leetcode.com/problems/longest-common-prefix/description/
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * */
    public static String longestCommonPrefix(String[] strs) {

        List<String> stringList = Arrays.stream(strs).sorted((a,b) -> a.length() - b.length()).collect(Collectors.toList());
        String minStr = stringList.get(0);
        Integer minLength = minStr.length();

        String res = minStr;

        for(int i = 0; i< strs.length;i++){
            while(!res.isEmpty()){
                if(strs[i].startsWith(res)){
                    break;
                }else
                    res = res.substring(0,res.length()-1);
            }
        }
        return res;
    }
}