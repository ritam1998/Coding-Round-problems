package leetcodeproblems.stringproblems;

public class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }
    /**
     * @LeetCode
     * @Important
     * @1910. Remove All Occurrences of a Substring
     * @https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?source=submission-noac
     *
     * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
     *
     * Find the leftmost occurrence of the substring part and remove it from s.
     * Return s after removing all occurrences of part.
     *
     * A substring is a contiguous sequence of characters in a string.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "daabcbaabcbc", part = "abc"
     * Output: "dab"
     * Explanation: The following operations are done:
     * - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
     * - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
     * - s = "dababc", remove "abc" starting at index 3, so s = "dab".
     * Now s has no occurrences of "abc".
     * Example 2:
     *
     * Input: s = "axxxxyyyyb", part = "xy"
     * Output: "ab"
     * Explanation: The following operations are done:
     * - s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
     * - s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
     * - s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
     * - s = "axyb", remove "xy" starting at index 1 so s = "ab".
     * Now s has no occurrences of "xy".
     * */
    public static String removeOccurrences(String s, String part) {
        int index = s.indexOf(part);
        String str = s;
        if(index == -1){
            return str;
        }else{
            str = s.replace(part,"");
        }
        return removeOccurrences(str,part);
    }
    public String removedOccurrences(String s, String part) {

        if (!s.contains(part)) {
            return s;
        }

        // Recursive step: Find the first occurrence of the substring.
        int index = s.indexOf(part);

        // Create the new string by excluding the substring.
        String remainingString = s.substring(0, index) + s.substring(index + part.length());

        // Recursively call the function with the new string.
        return removeOccurrences(remainingString, part);
    }
}
