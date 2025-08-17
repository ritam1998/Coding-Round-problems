package leetcodeproblems.divideandconquer;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;


/**
 *
 * @1985. Find the Kth Largest Integer in the Array
 * @https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/description/?envType=problem-list-v2&envId=divide-and-conquer
 *
 * You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.
 *
 * Return the string that represents the kth largest integer in nums.
 *
 * Note: Duplicate numbers should be counted distinctly. For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["3","6","7","10"], k = 4
 * Output: "3"
 * Explanation:
 * The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
 * The 4th largest integer in nums is "3".
 * Example 2:
 *
 * Input: nums = ["2","21","12","1"], k = 3
 * Output: "2"
 * Explanation:
 * The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
 * The 3rd largest integer in nums is "2".
 * Example 3:
 *
 * Input: nums = ["0","0"], k = 2
 * Output: "0"
 * Explanation:
 * The numbers in nums sorted in non-decreasing order are ["0","0"].
 * The 2nd largest integer in nums is "0".
 * */
public class FindTheKthLargestIntegerInTheArray {
    public static void main(String[] args) {
        System.out.println(kthLargestNumber(new String[]{"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"},3));
    }
    public static String kthLargestNumber(String[] nums, int k) {

        List<BigInteger> array = Arrays.stream(nums).map(BigInteger::new).sorted().collect(Collectors.toList());
        Stack<BigInteger> integerStack = new Stack<>();
        for(BigInteger numbers : array) integerStack.push(numbers);

        while(k > 1){
            integerStack.pop();
            k--;
        }

        System.out.println(integerStack);

        return integerStack.peek().toString();
    }
}
