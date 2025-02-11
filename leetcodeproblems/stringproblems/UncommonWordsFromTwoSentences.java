package leetcodeproblems.stringproblems;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UncommonWordsFromTwoSentences {
    public static void main(String[] args) {
        uncommonFromSentences("apple apple","banana");
    }
    /**
     * @Leetcode
     * @884. Uncommon Words from Two Sentences
     * @Important
     * @Stream
     * @https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
     *
     * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
     *
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     *
     * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
     *
     * Example 1:
     *
     * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
     *
     * Output: ["sweet","sour"]
     *
     * Explanation:
     *
     * The word "sweet" appears only in s1, while the word "sour" appears only in s2.
     *
     * Example 2:
     *
     * Input: s1 = "apple apple", s2 = "banana"
     *
     * Output: ["banana"]
     * */
    public static String[] uncommonFromSentences(String s1, String s2) {

        return Arrays.stream((s1+" "+s2).split(" "))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(v -> v.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

    }
}
