package leetcodeproblems.stringproblems;

import java.util.List;
import java.util.stream.Collectors;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode")); //AceCreIm // leotcede
        System.out.println(reverseVowel("IceCreAm"));
    }

    /**
     * @Important
     * @Leetcode
     * @TwoPointersMethod
     * @345. Reverse Vowels of a String
     * @https://leetcode.com/problems/reverse-vowels-of-a-string/description/
     * Given a string s, reverse only all the vowels in the string and return it.
     *
     * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     *
     * Example 1:
     *
     * Input: s = "IceCreAm"
     *
     * Output: "AceCreIm"
     *
     * Explanation:
     *
     * The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
     *
     * Example 2:
     *
     * Input: s = "leetcode"
     *
     * Output: "leotcede"
     * */

    private static String reverseVowel(String s){

        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            while ((start < end) && !checkIsVowel(chars[start]))
                start++;
            while ((start < end) && !checkIsVowel(chars[end]))
                end--;

            if(start < end){
                swapData(chars,start,end);
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    private static void swapData(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }

    public static String reverseVowels(String s) {

        if(s.isEmpty() || s.isBlank())
            return " ";

        List<Character> list = s.chars().mapToObj(c -> (char) c)
                .filter(ReverseVowelsOfAString::checkIsVowel)
                .collect(Collectors.toList());

        String c = s.chars().mapToObj(ch -> (char) ch)
                .map(value -> String.valueOf(checkIsVowel(value) ? " " : value))
                .collect(Collectors.joining());

        return finalBuild(c,list);
    }
    private static boolean checkIsVowel(char v){
        char value = Character.toLowerCase(v);
        return value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u';
    }
    private static String finalBuild(String value, List<Character> characters){

        int j = characters.size() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<value.length();i++){
            if(value.charAt(i) == ' '){
                stringBuilder.append(characters.get(j));
                j = j - 1;
            }else
                stringBuilder.append(value.charAt(i));
        }
        return stringBuilder.toString();
    }
}
