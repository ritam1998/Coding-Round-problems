package leetcodeproblems.sortingproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}},new int[]{4,8})));
    }
    /**
     * @LeetCode
     * @57. Insert Interval
     * @https://leetcode.com/problems/insert-interval/description/
     *
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval
     * and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
     *
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     *
     * Return intervals after the insertion.
     *
     * Note that you don't need to modify intervals in-place. You can make a new array and return it.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     * Example 2:
     *
     * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * Output: [[1,2],[3,10],[12,16]]
     * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
     * */
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length < 1 && newInterval.length <= 1) return new int[][]{Arrays.stream(newInterval).toArray()};
        else if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(newInterval);

        List<int[]> results = new ArrayList<>();


        for(int[] interval : intervals){
            if(interval[1] < newInterval[0]) results.add(interval);
            else if(interval[0] > newInterval[1]) {
                results.add(newInterval);
                newInterval = interval;
            }else{
                newInterval[0] = Math.min(interval[0],newInterval[0]);
                newInterval[1] = Math.max(interval[1],newInterval[1]);
            }
        }
        results.add(newInterval);

        return results.toArray(new int[results.size()][]);
    }
}
