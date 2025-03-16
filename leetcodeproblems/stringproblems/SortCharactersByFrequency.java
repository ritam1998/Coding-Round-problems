package leetcodeproblems.stringproblems;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("raaeaedere"));
    }
    /**
     * @LeetCode
     * @Medium
     * @451. Sort Characters By Frequency
     * @https://leetcode.com/problems/sort-characters-by-frequency/description/?envType=problem-list-v2&envId=sorting
     *
     *
     * Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
     *
     * Return the sorted string. If there are multiple answers, return any of them.
     *
     * Example 1:
     *
     * Input: s = "tree"
     * Output: "eert"
     * Explanation: 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input: s = "cccaaa"
     * Output: "aaaccc"
     * Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     *
     * Input: s = "Aabb"
     * Output: "bbAa"
     * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     * */
    public static String frequencySort(String s) {

        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0;i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i),new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> highest = null;
        Optional<List<Integer>> optionalIntegers = map.values().stream().max(Comparator.comparing(List::size));
        if(optionalIntegers.isPresent()) highest = optionalIntegers.get();

        List<List<Integer>> entry = map.values().stream().sorted(Comparator.comparing(List::size))
                .collect(Collectors.toList());

        for(int i = entry.size() - 1;i>=0;i--){
            assert highest != null;
            if(entry.get(i).size() == highest.size()) {
                for(Integer index : entry.get(i)) stringBuilder.append(s.charAt(index));
            }else{
                for (Integer index : entry.get(i)) stringBuilder.append(s.charAt(index));
            }
        }
        return stringBuilder.toString();
    }
}
