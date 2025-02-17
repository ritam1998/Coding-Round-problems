package leetcodeproblems.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterTilePossibilities {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities2("AAABBC"));
    }
    /**
     * @LeetCode
     * @Important
     * @1079. Letter Tile Possibilities
     * @https://leetcode.com/problems/letter-tile-possibilities/description/?envType=daily-question&envId=2025-02-17
     *
     * You have n  tiles, where each tile has one letter tiles[i] printed on it.
     *
     * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
     *
     *
     * Example 1:
     *
     * Input: tiles = "AAB"
     * Output: 8
     * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
     * Example 2:
     *
     * Input: tiles = "AAABBC"
     * Output: 188
     * Example 3:
     *
     * Input: tiles = "V"
     * Output: 1
     * */
    public static int numTilePossibilities2(String tiles) {

        int chars[] = new int[26];
        for(char ch : tiles.toCharArray()) chars[ch - 'A']++;
        System.out.println(Arrays.toString(chars));
        return findSequences(chars);
    }
    private static int findSequences(int[] chars){
        int totalCount = 0;
        for(int pos = 0;pos<chars.length;pos++){
            if(chars[pos] != 0){
                totalCount++;
                chars[pos]--;
                System.out.println("chars[pos]--: "+chars[pos]);
                totalCount += findSequences(chars);
                System.out.println("totalCount: "+totalCount);
                chars[pos]++;
            }
        }
        return totalCount;
    }

    public static int numTilePossibilities(String tiles) {
        List<String> results = new ArrayList<>();
        permute(tiles.toCharArray(),0,results);
        System.out.println(results);
        return results.size() - 1;
    }
    public static void permute(char[] chars,int start,List<String> results){

        /**
         * Here we check if string length is 1 then I have added in list.
         * Example:
         * Input: String str = 'v', Output: [v];
         * */
        if(start == chars.length - 1) results.add(String.valueOf(chars));
        else {
            for(int i = 0;i<chars.length;i++){
                swap(chars,start,i);
                permute(chars,start+1,results);
                /**
                 * @Important
                 * @Steps
                 * BackTracking: The Swap(char,start,i) after the recursive call is crucial.
                 * It restores the original array state so that other permutation are correctly generated
                 * */
                swap(chars,start,i);
            }
        }
    }
    public static void swap(char[] chars,int i,int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
