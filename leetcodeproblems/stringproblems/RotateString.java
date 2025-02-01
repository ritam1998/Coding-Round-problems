package leetcodeproblems.stringproblems;

public class RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde","abced"));
    }
    /**
     * @Important
     * @LeetCode
     * @796. Rotate String,
     * @https://leetcode.com/problems/rotate-string/description/
     * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
     *
     * A shift on s consists of moving the leftmost character of s to the rightmost position.
     *
     * For example, if s = "abcde", then it will be "bcdea" after one shift.
     *
     * Example 1:
     *
     * Input: s = "abcde", goal = "cdeab"
     * Output: true
     * Example 2:
     *
     * Input: s = "abcde", goal = "abced"
     * Output: false
     * */
    public static boolean rotateString(String s, String goal) {

        String v = s;
        boolean flag = false;
        for(int i =0;i<s.length();i++){
            v = rotated(v.toCharArray());
            if(v.equalsIgnoreCase(goal))
                flag = true;
        }
        return flag;
    }
    private static String rotated(char[] s){
        char value = s[0];
        for(int i = 0;i<s.length-1;i++){
            s[i] = s[i+1];
        }
        s[s.length-1] = value;
        return String.valueOf(s);
    }
}
