package leetcodeproblems;

/**
 * https://leetcode.com/problems/reverse-integer/description/
 * */

public class ReverseIntegerProblem {
    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
    public static Integer reverse(int x){
        Integer reverseData = 0;
        Integer num = Math.abs(x);
        int r;
        while(num != 0){
            r = num%10;
            reverseData = (reverseData*10)+r;
            if(reverseData > (Integer.MAX_VALUE-r) / 10) /* to prevent the Overflow of Integer */
                return 0;
            num = num/10;
        }
        return (x>0) ? reverseData : (-reverseData);
    }
}
