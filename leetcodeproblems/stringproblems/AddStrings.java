package leetcodeproblems.stringproblems;

import java.math.BigInteger;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("456","77"));
    }
    /**
     * @Leetcode
     * @415. Add Strings
     * @https://leetcode.com/problems/add-strings/description/
     * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
     *
     * You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.
     *
     * Example 1:
     *
     * Input: num1 = "11", num2 = "123"
     * Output: "134"
     * Example 2:
     *
     * Input: num1 = "456", num2 = "77"
     * Output: "533"
     * Example 3:
     *
     * Input: num1 = "0", num2 = "0"
     * Output: "0"
     * */

    public static String addStrings(String num1, String num2) {
        BigInteger bigIntegerNum1 =
                new BigInteger(num1.trim()).add(new BigInteger(num2.trim()));
        return bigIntegerNum1.toString();
    }
}
