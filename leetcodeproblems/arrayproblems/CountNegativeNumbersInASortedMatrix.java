package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountNegativeNumbersInASortedMatrix {
    public static void main(String[] args) {
        //[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]
        System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
    }
    /**
     * @LeetCode
     * @1351. Count Negative Numbers in a Sorted Matrix
     * @https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
     *
     * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.
     *
     * Example 1:
     *
     * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
     * Output: 8
     * Explanation: There are 8 negatives number in the matrix.
     * Example 2:
     *
     * Input: grid = [[3,2],[1,0]]
     * Output: 0
     * */
    public static int countNegatives(int[][] grid) {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] < 0) integers.add(grid[i][j]);
            }
        }
        return integers.size();
    }
}
