package leetcodeproblems.counting;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
    }
    /**
     * @1941. Check if All Characters Have Equal Number of Occurrences
     * @https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/description/?envType=problem-list-v2&envId=counting
     *
     * Given a string s, return true if s is a good string, or false otherwise.
     *
     * A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abacbc"
     * Output: true
     * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
     * Example 2:
     *
     * Input: s = "aaabb"
     * Output: false
     * Explanation: The characters that appear in s are 'a' and 'b'.
     * 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
     * */
    public static boolean areOccurrencesEqual(String s) {
        Set<Long> set = new HashSet<>();
        s.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((key, value) -> set.add(value));
        return set.size() == 1;
    }
}
