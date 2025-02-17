package leetcodeproblems.arrayproblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumOfUniqueElements {
    public static void main(String[] args) {
        System.out.println(sumOfUnique(new int[]{1,2,3,2}));
    }
    /**
     * @LeetCode
     * @1748. Sum of Unique Elements
     * @https://leetcode.com/problems/sum-of-unique-elements/description/
     *
     * You are given an integer array nums. The unique elements of an array are the elements that appear exactly once in the array.
     *
     * Return the sum of all the unique elements of nums.
     *
     * Example 1:
     *
     * Input: nums = [1,2,3,2]
     * Output: 4
     * Explanation: The unique elements are [1,3], and the sum is 4.
     * Example 2:
     *
     * Input: nums = [1,1,1,1,1]
     * Output: 0
     * Explanation: There are no unique elements, and the sum is 0.
     * Example 3:
     *
     * Input: nums = [1,2,3,4,5]
     * Output: 15
     * Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.
     *
     * */
    public static int sumOfUnique(int[] nums) {

        List<Integer> m = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(mv -> mv.getValue() <= 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        AtomicInteger count = new AtomicInteger();
        m.forEach(count::addAndGet);

        return count.get();
    }
}
