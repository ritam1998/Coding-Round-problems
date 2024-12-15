package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * We define the following terms:
 *
 * Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
 *
 * For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.
 *
 * A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.
 * Given a string, , and an integer, , complete the function so that it finds the lexicographically smallest and largest substrings of length .
 *
 * Function Description
 *
 * Complete the getSmallestAndLargest function in the editor below.
 *
 * getSmallestAndLargest has the following parameters:
 *
 * string s: a string
 * int k: the length of the substrings to find
 * Returns
 *
 * string: the string ' + "\n" + ' where and are the two substrings
 * Input Format
 *
 * The first line contains a string denoting s.
 * The second line contains an integer denoting k.
 *
 * @Link https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true
 * */

public class LexicographicalOrderSubstring {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava",3));
        getSmallestAndLargest1("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaDFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs",144);
    }
    public static String getSmallestAndLargest(String input,Integer k){
        List<String> stringList = new ArrayList<>();
        for(int i = 0;i <= input.length() - k;i++){
            stringList.add(input.substring(i,i+k));
        }
        Collections.sort(stringList);
        String smallest = stringList.get(0);
        String highest = stringList.get(stringList.size() - 1);

        if(smallest.equalsIgnoreCase(highest))
            return smallest;
        else
            return smallest+ "\n" +highest;
    }
    public static void getSmallestAndLargest1(String input,Integer k){

        String smallest = input.substring(0,k);
        String highest = input.substring(0,k);

        for(int i = 0;i <= input.length() - k;i++){
            String st = input.substring(i,i+k);
            if(st.compareTo(smallest) < 0)
                smallest = st;
            if(st.compareTo(highest) > 0)
                highest = st;
        }
        System.out.println(smallest+ "\n" +highest);
    }
}
