package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {
    public static void main(String[] args) {
        String[] find = findOccurrences("we will we will rock you","we","will");
        Arrays.stream(find).forEach(System.out::println);
    }
    /**
     * @Important
     * @Leetcode
     * @1078. Occurrences After Bi-gram
     * @https://leetcode.com/problems/occurrences-after-bigram/description/
     *
     * Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
     *
     * Return an array of all the words third for each occurrence of "first second third".
     *
     *
     * Example 1:
     *
     * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
     * Output: ["girl","student"]
     * Example 2:
     *
     * Input: text = "we will we will rock you", first = "we", second = "will"
     * Output: ["we","rock"]
     * */
    public static String[] findOccurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < words.length; ++i) {
            if (first.equals(words[i - 2]) && second.equals(words[i - 1]))
                ans.add(words[i]);
        }
        return ans.toArray(new String[0]);
    }
}
