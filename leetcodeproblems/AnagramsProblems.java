package leetcodeproblems;

import java.util.Arrays;
import java.util.Locale;

public class AnagramsProblems {
    public static void main(String[] args) {
        System.out.println(isAnagrams("Hello","hello"));
        System.out.println(countNumber(new int[]{1,-2,4,-5,1}));
    }
    public static boolean isAnagrams(String s1, String s2){

        char[] array1 = s1.toLowerCase(Locale.ROOT).toCharArray();
        char[] array2 = s2.toLowerCase(Locale.ROOT).toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1,array2);
    }
    /**
     *
     * A subarray of an -element array is an array composed from a contiguous block of the original array's elements. For example, if ,
     * then the subarrays are [1], [2],[3] ,[1,2] ,[2,3] , and [1,2,3]. Something like  would not be a subarray as it's not a contiguous subsection of the original array.
     * The sum of an array is the total sum of its elements.
     * An array's sum is negative if the total sum of its elements is negative.
     * An array's sum is positive if the total sum of its elements is positive.
     * Given an array of  integers, find and print its number of negative subarrays on a new line.
     *
     * Input Format
     *
     * The first line contains a single integer, , denoting the length of array .
     * The second line contains  space-separated integers describing each respective element, , in array .
     *
     * @Link https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
     * */

    public static int countNumber(int arr[]){

        int count = 0;
        for(int  i = 0;i<arr.length;i++){
            for(int j = i;j<arr.length;j++){
                int sum = 0;
                for(int m = i;m<=j;m++){
                    sum += arr[m];
                }
                if(sum < 0){
                    count++;
                }
            }
        }
        return count;
    }
}
