package leetcodeproblems;


import java.util.Stack;

/**
 * In computer science, a stack or LIFO (last in, first out) is an abstract data type that serves as a collection of elements,
 * with two principal operations: push, which adds an element to the collection, and pop, which removes the last element that was added.
 *
 * @Link https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
 * @Important
 * */

public class CorrectlyBalancedStrings {
    public static void main(String[] args) {
        System.out.println(checkBalancedORNot("[{()}]"));
    }
    public static boolean checkBalancedORNot(String data){

        Stack<Character> characterStack = new Stack<>();
        for(Character ch : data.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '[')
                characterStack.push(ch);
            else if(ch == '}' && characterStack.contains('{') || ch == ')' && characterStack.contains('(') || ch == ']' && characterStack.contains('['))
                characterStack.pop();
            else
                characterStack.push(ch);
        }
        return characterStack.size() == 0;
    }
}
