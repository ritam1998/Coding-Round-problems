package leetcodeproblems.dailyleetcodeproblems;

public class FindTheKThCharacterInStringGameI {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
    /**
     * @Easy
     * @Tricky
     * @Important
     * @3304. Find the K-th Character in String Game I
     * @https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/description/?envType=daily-question&envId=2025-07-03
     *
     * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
     *
     * You are given a positive integer k.
     *
     * Now Bob will ask Alice to perform the following operation forever:
     *
     * Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
     * For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".
     *
     * Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.
     *
     *
     *
     * Example 1:
     *
     * Input: k = 5
     *
     * Output: "b"
     *
     * Explanation:
     *
     * Initially, word = "a". We need to do the operation three times:
     *
     * Generated string is "b", word becomes "ab".
     * Generated string is "bc", word becomes "abbc".
     * Generated string is "bccd", word becomes "abbcbccd".
     * Example 2:
     *
     * Input: k = 10
     *
     * Output: "c"
     * */
    public static char kthCharacter(int k) {
        int toAdd = 0;
        while (k > 1){
            k = k - closestElement(k-1);
            toAdd++;
        }
        return (char) ('a'+toAdd);
    }
    private static int closestElement(int num) {
        int ans = 1;
        while(ans<<1 <= num) ans = ans << 1;
        return ans;
    }
}
