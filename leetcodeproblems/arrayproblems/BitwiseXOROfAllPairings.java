package leetcodeproblems.arrayproblems;

public class BitwiseXOROfAllPairings {
    public static void main(String[] args) {
        System.out.println(xorAllNum(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0}));
    }
    /**
     * @Leetcode
     * @Medium
     * @Important
     * @2425. Bitwise XOR of All Pairings
     * @https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/
     *
     * You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. Let there be another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).
     *
     * Return the bitwise XOR of all integers in nums3.
     *
     *
     * Example 1:
     *
     * Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
     * Output: 13
     * Explanation:
     * A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
     * The bitwise XOR of all these numbers is 13, so we return 13.
     * Example 2:
     *
     * Input: nums1 = [1,2], nums2 = [3,4]
     * Output: 0
     * Explanation:
     * All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
     * and nums1[1] ^ nums2[1].
     * Thus, one possible nums3 array is [2,5,1,6].
     * 2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
     * */
    public static int xorAllNum(int[] num1, int[] num2) {

        int result = 0;
        for (Integer n : num1) {
            for (Integer n1 : num2) {
                result = result ^ (n ^ n1);
            }
        }
        return result;
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {

        // Initialize XOR results for both arrays
        int xor1 = 0;
        int xor2 = 0;

        // Get lengths of both arrays
        int len1 = nums1.length;
        int len2 = nums2.length;

        // If nums2 length is odd, each element in nums1 appears odd times in final result
        if (len2 % 2 != 0) {
            for (int num : nums1) {
                xor1 ^= num;
            }
        }

        // If nums1 length is odd, each element in nums2 appears odd times in final result
        if (len1 % 2 != 0) {
            for (int num : nums2) {
                xor2 ^= num;
            }
        }

        // Return XOR of both results
        return xor1 ^ xor2;
    }
}
