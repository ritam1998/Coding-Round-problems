package leetcodeproblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * In computer science, a set is an abstract data type that can store certain values, without any particular order, and no repeated values(Wikipedia).
 * {1,2,3} is an example of a set, but {1,2,2} is not a set. Today you will learn how to use sets in java by solving this problem.
 *
 * You are given n pairs of strings. Two pairs (a,b)  and (c,d) are identical if a=c and b=d. That also implies (a,b) is not same as (b,a).
 * After taking each pair as input, you need to print number of unique pairs you currently have.
 *
 * Complete the code in the editor to solve this problem.
 *
 * @Link https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true
 * */
public class UniquePairs {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        findPairs(pair_left,pair_right,t);
    }
    public static void findPairs(String[] p1,String[] p2,int len){
        Set<String> strings = new HashSet<>();

        for(int i = 0;i < len;i++){
            String s = p1[i]+","+p2[i];
            strings.add(s);
            System.out.println(strings.size());
        }
    }
}
