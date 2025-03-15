package leetcodeproblems.arrayproblems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(mySqrt(4));
        System.out.println(myPow(2.00000,10));
    }
    public static boolean containsDuplicate(int[] nums) {

        List<Boolean> list = new ArrayList<>();
        Map<Integer,Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        map.forEach((k,v) -> {
            if(v > 1) list.add(false);
            else list.add(true);
        });

        Optional<Boolean> flag = list.stream().filter(v -> v.equals(false)).findFirst();
        return flag.isPresent();
    }
    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
    public static double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}
