package leetcodeproblems.sortingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
    /**
     * @Leetcode
     * @56. Merge Intervals
     * @https://leetcode.com/problems/merge-intervals/description/
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     * Example 3:
     *
     * Input: intervals = [[4,7],[1,4]]
     * Output: [[1,7]]
     * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
     * */
    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;
        /*
         * Sorting the element
         * */
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();
        int [] currentInterval = intervals[0];
        result.add(currentInterval);

        for(int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if(currentEnd >= nextStart) currentInterval[1] = Math.max(currentEnd,nextEnd);
            else{
                currentInterval = interval;
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
