package leetcodeproblems.dailyleetcodeproblems;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(3));
    }
    /**
     * @231. Power of Two
     * @https://leetcode.com/problems/power-of-two/description/?envType=daily-question&envId=2025-08-09
     * Given an integer n, return true if it is a power of two. Otherwise, return false.
     *
     * An integer n is a power of two, if there exists an integer x such that n == 2x.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1
     * Output: true
     * Explanation: 20 = 1
     * Example 2:
     *
     * Input: n = 16
     * Output: true
     * Explanation: 24 = 16
     * Example 3:
     *
     * Input: n = 3
     * Output: false
     * */
    public static boolean isPowerOfTwo(int n) {

        for(int i = 0;i<=31;i++){
            int currentPow = 1 << i;
            if(currentPow == n) return true;
        }
        return false;
    }
}
