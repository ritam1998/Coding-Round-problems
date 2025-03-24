package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
    /**
     * @LeetCode
     * @Important
     * @204. Count Primes
     * @https://leetcode.com/problems/count-primes/description/
     *
     * Given an integer n, return the number of prime numbers that are strictly less than n.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 10
     * Output: 4
     * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
     * Example 2:
     *
     * Input: n = 0
     * Output: 0
     * Example 3:
     *
     * Input: n = 1
     * Output: 0
     *
     *
     * Constraints:
     *
     * 0 <= n <= 5 * 106
     * */
    public static int countPrimes(int n) {
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(checkPrime(i)) integerList.add(i);
        }
        return integerList.size();
    }
    public static boolean checkPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2;i<n;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public static int countPrimesN(int n) {

        int count = 0;
        int[] prime = new int[n]; // No need for n+1 since we're counting primes strictly less than n

        // Initialize the prime array
        for (int i = 2; i < n; i++) {
            prime[i] = 1; // Assume all numbers are prime initially
        }

        // Sieve of Eratosthenes
        for (int i = 2; i * i < n; i++) {
            if (prime[i] == 1) { // If i is prime
                for (int j = i * i; j < n; j += i) { // Mark multiples of i as non-prime
                    prime[j] = 0;
                }
            }
        }

        // Count the primes
        for (int i = 2; i < n; i++) {
            if (prime[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
