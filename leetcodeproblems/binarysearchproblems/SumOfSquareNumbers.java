package leetcodeproblems.binarysearchproblems;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
    /**
     * @Leetcode
     * @Medium
     * @633. Sum of Square Numbers
     * @https://leetcode.com/problems/sum-of-square-numbers/description/?envType=problem-list-v2&envId=binary-search
     *
     * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
     *
     *
     *
     * Example 1:
     *
     * Input: c = 5
     * Output: true
     * Explanation: 1 * 1 + 2 * 2 = 5
     * Example 2:
     *
     * Input: c = 3
     * Output: false
     * */
    public static boolean judgeSquareSum(int c) {

        int start = 0;
        int end = (int) Math.sqrt(c);

        while(start <= end){
            int sum = (int) (Math.pow(start,2) + Math.pow(end,2));
            if(sum == c) return true;
            else if(sum > c) end--;
            else start++;
        }
        return false;
    }
}
