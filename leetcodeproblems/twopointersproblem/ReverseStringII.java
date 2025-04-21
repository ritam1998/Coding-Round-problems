package leetcodeproblems.twopointersproblem;


public class ReverseStringII {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
    }
    /**
     * @LeetCode
     * @541. Reverse String II
     * @https://leetcode.com/problems/reverse-string-ii/description/?envType=problem-list-v2&envId=two-pointers
     *
     * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
     *
     * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcdefg", k = 2
     * Output: "bacdfeg"
     * Example 2:
     *
     * Input: s = "abcd", k = 2
     * Output: "bacd"
     * */
    public static String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int i = 0;
        int n = array.length;
        while (i < n){
            int j = Math.min(i+k-1,n-1);
            swapCharacter(array,i,j);
            i = i + 2*k;
        }
        return new String(array);
    }
    static void swapCharacter(char[] chars,int i,int j){
        while (i < j){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
