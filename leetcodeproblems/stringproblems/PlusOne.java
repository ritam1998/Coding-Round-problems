package leetcodeproblems.stringproblems;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public static void main(String[] args) throws ParseException {
        System.out.println(plusOne(new int[]{5,2,2,6,5,7,1,9,0,3,8,6,8,6,5,2,1,8,7,9,8,3,8,4,7,2,5,8,9}));
    }
    /**
     * @LEETCODE
     * @66. Plus One
     * @https://leetcode.com/problems/plus-one/description/
     * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
     *
     * Increment the large integer by one and return the resulting array of digits.
     *
     * Example 1:
     *
     * Input: digits = [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Incrementing by one gives 123 + 1 = 124.
     * Thus, the result should be [1,2,4].
     * Example 2:
     *
     * Input: digits = [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     * Incrementing by one gives 4321 + 1 = 4322.
     * Thus, the result should be [4,3,2,2].
     * Example 3:
     *
     * Input: digits = [9]
     * Output: [1,0]
     * Explanation: The array represents the integer 9.
     * Incrementing by one gives 9 + 1 = 10.
     * Thus, the result should be [1,0].
     * */
    public static int[] plusOne(int[] digits) throws ParseException {
        String v = Arrays.stream(digits).boxed().map(m -> m+"").collect(Collectors.joining());
        BigInteger bigInteger = new BigInteger(v);
        BigInteger result = bigInteger.add(BigInteger.ONE);

        String convertedValue = result.toString();
        int[] stringList = convertedValue.chars().mapToObj(m->(char) m)
                .map(val -> Integer.parseInt(String.valueOf(val)))
                .mapToInt(Integer::intValue)
                .toArray();

        return stringList;
    }
}
