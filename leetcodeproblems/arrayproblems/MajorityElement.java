package leetcodeproblems.arrayproblems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
    /**
     * @Leetcode
     * @169. Majority Element
     * @https://leetcode.com/problems/majority-element/description/
     *
     * Given an array nums of size n, return the majority element.
     *
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     * */
    public static int majorityElement(int[] nums) {

        Map.Entry<Integer,Long> m = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue,newValue) -> oldValue,LinkedHashMap::new))
                .entrySet()
                .stream()
                .findFirst()
                .get();

        return m.getKey();
    }
}
