package codingProblemsGivenByCompany;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FifthNearestPalindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number N: ");
        int N = scanner.nextInt();

        Integer[] palindromes = new Integer[5];
        int count = 0;

        // Find palindromes smaller than N
        for (int i = N - 1; i >= 0 && count < 5; i--) {
            if (isPalindrome(i) && i >= 10) {
                palindromes[count++] = i;
            }
        }

        // Find palindromes greater than N
        for (int i = N + 1; count < 5; i++) {
            if (isPalindrome(i)) {
                palindromes[count++] = i;
            }
        }

        // Sort palindromes by distance from N
        Arrays.sort(palindromes, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int distA = Math.abs(N - a);
                int distB = Math.abs(N - b);
                return distA == distB ? a - b : distA - distB;
            }
        });

        // Output the fifth nearest palindrome
        System.out.println("The fifth nearest palindrome is: " + palindromes[4]);
    }

    // Method to check if a number is a palindrome
    public static boolean isPalindrome(int num) {
        int original = num;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return original == reverse;
    }
}
