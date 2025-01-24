package leetcodeproblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemovedAllVowels {

    public static void main(String[] args) {
        System.out.println(removedAllVowels("programming is fun"));
        returnLastElement();
        System.out.println(removedUnderScore("string_function_test"));
    }
    /**
     *  Given a string, remove all vowels (both uppercase and lowercase) and capitalise the first letter of each word in the resulting string.
     * 𝐄𝐱𝐚𝐦𝐩𝐥𝐞:
     * 𝐈𝐧𝐩𝐮𝐭: "programming is fun"
     * 𝐎𝐮𝐭𝐩𝐮𝐭: "Prgrmmng S Fn"
     * 𝐄𝐱𝐩𝐥𝐚𝐧𝐚𝐭𝐢𝐨𝐧:
     * Remove vowels: "prgrmmng s fn"
     * Capitalise first letter of each word: "Prgrmmng S Fn"
     *
     * @return*/

    private static String removedAllVowels(String data){

        Function<Character,String> stringFunction = character -> {
            StringBuilder stringBuilder = new StringBuilder();
            if(character.equals('a') || character.equals('e') || character.equals('i') || character.equals('o') || character.equals('u'))
                stringBuilder.append("");
            else
                stringBuilder.append(character);
            return stringBuilder.toString();
        };

        return Arrays.stream(data.split(" "))
                .map(v-> v.chars().mapToObj(m -> (char) m).map(stringFunction).collect(Collectors.joining()))
                .map(value -> String.valueOf(Character.toUpperCase(value.charAt(0))) + value.subSequence(1, value.length()))
                .collect(Collectors.joining(" "));
    }
    /**
     * Given a singly linked list, return the k-th last element. If k is greater than the size of the linked list, return null.
     * 𝐄𝐱𝐚𝐦𝐩𝐥𝐞:
     * 𝐈𝐧𝐩𝐮𝐭: head = [1, 2, 3, 4, 5], k = 2
     * 𝐎𝐮𝐭𝐩𝐮𝐭: 4
     * 𝐄𝐱𝐩𝐥𝐚𝐧𝐚𝐭𝐢𝐨𝐧: The 2nd last element is 4.
     * */

    private static void returnLastElement(){

        int[] a = {1,2,3,4,5};

        List<Integer> integerList = new LinkedList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        System.out.println(integerList.get(integerList.size()-2));
    }

    /**
     * Write a program to remove underscore from a given string and make update the first character to uppercase
     * Example:
     * Input: "string_function_test"
     * output: "String Function Test"
     * */

    private static String removedUnderScore(String data){
        return Arrays.stream(data.split("_"))
                .map(value -> String.valueOf(Character.toUpperCase(value.charAt(0))) + value.subSequence(1,value.length()))
                .collect(Collectors.joining(" "));
    }
}
