package leetcodeproblems.stringproblems;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    /**
     * @LeetCode
     * @Important
     * @49. Group Anagrams
     * @https://leetcode.com/problems/group-anagrams/description/
     *
     * Given an array of strings strs, group the
     * anagrams
     *  together. You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     *
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     *
     * Explanation:
     *
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
     * Example 2:
     *
     * Input: strs = [""]
     *
     * Output: [[""]]
     *
     * Example 3:
     *
     * Input: strs = ["a"]
     *
     * Output: [["a"]]
     * */

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            stringList.add(String.valueOf(chars));
        }

        Map<String,Long> stringLongMap = stringList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Set<String> stringSet = stringLongMap.keySet();
        List<String> finalStringList = new ArrayList<>(stringSet);

        for(int i = 0;i<finalStringList.size();i++){
            List<String> strings = new ArrayList<>();
            for(int j = 0;j< strs.length;j++){
                if(isAnagram(strs[j],finalStringList.get(i))){
                    strings.add(strs[j]);
                }
            }
            lists.add(strings);
        }


        System.out.println(lists);
        return null;
    }
    public static boolean isAnagram(String s1,String s2){

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1,chars2);
    }
    /**
     * @Leetcode
     * @Solution From Leetcode
     * */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
