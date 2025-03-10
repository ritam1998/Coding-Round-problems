package streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InterviewQuestionsPrograms {

    public static void main(String[] args) {

        getPrimeNumberFromList();
        getVowelsFromStringUsingPattern();
        removedDuplicateElements();
    }

    /**
     * @Important
     * 1. Write a Java program to check if the given number is a prime number.
     * */

    private static void getPrimeNumberFromList(){

        List<Integer> integerList = List.of(1,4,2,9,5,6,8,7,15,18,14,20,11,13);
        Predicate<Integer> predicate = n -> {
            if(n == 1 || n == 0)
                return false;
            if(n == 2)
                return true;
            for(int i=2; i<= n/2; i++){
                if(n%i == 0)
                    return false;
            }
            return true;
        };

        Map<Boolean, List<Integer>> primeList = integerList.stream().collect(Collectors.partitioningBy(predicate));
        List<Integer> p = primeList.get(true);
        System.out.println("PRIME NUMBERS: "+p);
    }

    /**
     * @Important
     * Write a Java program to check if a vowel is present in a string.
     * */

    private static void getVowelsFromStringUsingPattern(){

        String data = "Hello";
        boolean vowels = data.toLowerCase().matches(".*[aeiou]*.");
        System.out.println("VOWELS PRESENT IN STRING: "+vowels);
    }

    /**
     * How do remove duplicates from a given array?
     * */
    private static void removedDuplicateElements(){

        List<Integer> integerList = List.of(1, 1, 2, 2, 3, 4, 5);

    }
}
