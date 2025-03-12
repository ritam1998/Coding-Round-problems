package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(11, 19)));
    }
    /**
     * @Leetcode
     * @Important
     * @2523. Closest Prime Numbers in Range
     * @https://leetcode.com/problems/closest-prime-numbers-in-range/description/?envType=daily-question&envId=2025-03-07
     *
     * Given two positive integers left and right, find the two integers num1 and num2 such that:
     *
     * left <= num1 < num2 <= right .
     * Both num1 and num2 are prime numbers.
     * num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
     * Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
     *
     *
     *
     * Example 1:
     *
     * Input: left = 10, right = 19
     * Output: [11,13]
     * Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
     * The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
     * Since 11 is smaller than 17, we return the first pair.
     * Example 2:
     *
     * Input: left = 4, right = 6
     * Output: [-1,-1]
     * Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
     * */
    public static int[] closestPrimes(int left, int right) {

        /**
         * {@Step-1} find the prime numbers in given range.
         * {@Step-2} All the prime numbers stored in arraylist.
         * {@Step-3} Find minimum distance using {@Link minimumRange()}
         * */
        List<Integer> integers = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(isPrime(i)) {
                integers.add(i);
            }
        }
        List<Integer> sortedList = integers.stream().sorted().collect(Collectors.toList());

        if(sortedList.size() < 2) return new int[] {-1,-1};
        return minimumRange(sortedList);
    }
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2;i<num;i++){
            if(num%i == 0) return false;
        }
        return true;
    }
    public static int[] minimumRange(List<Integer> integerList){

        int minimumNumberDifference = Integer.MAX_VALUE;
        int[] closestNumbers = new int[2];
        for(int index = 1;index<integerList.size();index++){
            int distanceDifference = integerList.get(index) - integerList.get(index-1);
            if(distanceDifference < minimumNumberDifference){
                minimumNumberDifference = distanceDifference;
                closestNumbers[0] = integerList.get(index-1);
                closestNumbers[1] = integerList.get(index);
            }
        }
        return closestNumbers;
    }
    /**
     * @Leetcode Solution
     * @Optimize Solution
     * */
    public static int[] closestPrimess(int left, int right) {

        boolean[] sieve = new boolean[right + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minGap = Integer.MAX_VALUE;
        int[] result = {-1, -1};

        for (int i = 1; i < primes.size(); i++) {
            int gap = primes.get(i) - primes.get(i - 1);
            if (gap < minGap) {
                minGap = gap;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }
        return result;
    }
}
