package leetcodeproblems.dailyleetcodeproblems;

import java.util.Arrays;

public class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
    }
    /**
     * @leetcode
     * @869. Reordered Power of 2
     * @https://leetcode.com/problems/reordered-power-of-2/description/?envType=daily-question&envId=2025-08-10
     *
     * You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
     *
     * Return true if and only if we can do this so that the resulting number is a power of two.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1
     * Output: true
     * Example 2:
     *
     * Input: n = 10
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= n <= 109
     * */
    public static boolean reorderedPowerOf2(int n) {
        var primarySortedNumber = sortNumber(n);
        for(int i = 0;i<31;i++){
            int currentPower =  1<<i;
            String currentSortedNumber = sortNumber(currentPower);
            if(currentSortedNumber.equals(primarySortedNumber)) return true;
        }
        return false;
    }
    public static String sortNumber(int number){
        char[] chars = String.valueOf(number).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
