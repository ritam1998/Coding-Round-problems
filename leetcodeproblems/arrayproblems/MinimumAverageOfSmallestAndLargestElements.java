package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MinimumAverageOfSmallestAndLargestElements {
    public static void main(String[] args) {
        System.out.println(minimumAverage(new int[]{7,8,3,4,15,13,4,1}));
    }
    /**
     * @3194. Minimum Average of Smallest and Largest Elements
     * @https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements/description/
     *
     * You have an array of floating point numbers averages which is initially empty. You are given an array nums of n integers where n is even.
     *
     * You repeat the following procedure n / 2 times:
     *
     * Remove the smallest element, minElement, and the largest element maxElement, from nums.
     * Add (minElement + maxElement) / 2 to averages.
     * Return the minimum element in averages.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [7,8,3,4,15,13,4,1]
     *
     * Output: 5.5
     *
     * Explanation:
     *
     * step	nums	averages
     * 0	[7,8,3,4,15,13,4,1]	[]
     * 1	[7,8,3,4,13,4]	[8]
     * 2	[7,8,4,4]	[8,8]
     * 3	[7,4]	[8,8,6]
     * 4	[]	[8,8,6,5.5]
     * The smallest element of averages, 5.5, is returned.
     * */
    public static double minimumAverage(int[] nums) {

        List<Double> averageList = new ArrayList<>();
        List<Integer> integers = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        minimumAverageList(integers,averageList);
        Optional<Double> optionalDouble = averageList.stream().sorted().findFirst();
        return optionalDouble.orElseGet(() -> optionalDouble.orElse(0.0));
    }
    private static void minimumAverageList(List<Integer> integerList,List<Double> averageList){

        if(integerList.size() == 0)
            return;

        int minimum = integerList.get(0);
        int maximum = integerList.get(integerList.size()-1);
        Double value = (double) (maximum + minimum) / 2;

        averageList.add(value);
        integerList.remove(0);
        integerList.remove(integerList.size()-1);

        minimumAverageList(integerList,averageList);
    }
}
