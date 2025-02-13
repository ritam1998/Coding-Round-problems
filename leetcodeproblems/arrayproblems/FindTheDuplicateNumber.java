package leetcodeproblems.arrayproblems;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
    /**
     * @LeetCode
     * @287. Find the Duplicate Number
     * @https://leetcode.com/problems/find-the-duplicate-number/description/
     *
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and using only constant extra space.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,4,2,2]
     * Output: 2
     * Example 2:
     *
     * Input: nums = [3,1,3,4,2]
     * Output: 3
     * Example 3:
     *
     * Input: nums = [3,3,3,3,3]
     * Output: 3
     * */
    public static int findDuplicate(int[] nums) {

        Optional<Integer> integerOptional = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(v -> v.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        return integerOptional.get();
    }
}
