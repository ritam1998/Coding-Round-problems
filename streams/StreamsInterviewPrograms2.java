package streams;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsInterviewPrograms2 {

    public static void main(String[] args) {

        countOfEachCharacter();
        findTheMaxElement();
        findDuplicateElement();
        eachElementCount();
        convertObjectUpperCase();

        convertTheSortedArray();
        performCubeOnList();
        concatenateStream();
        sortingAsAscOrder();
        sortingAsDescOrder();
        appearsRepeatedValue();

        findFirstRepeatedCharacter();
        findFirstNonRepeatedCharacter();
        findMaximumValue();
        totalNumberOfElement();
        findTheFirstElement();

        findOutAllTheNumbers();
        findDuplicateElements();

        findTheSameLengthInString();

        StreamsInterviewPrograms2 streamsInterviewPrograms2 = new StreamsInterviewPrograms2();
        streamsInterviewPrograms2.checkListIsEmpty();
        streamsInterviewPrograms2.storedInSortedOrder();
    }

    /**
     * Write a program to print the count of each character in a String?
     * @SEE removed all space from string
     * @Important
     * @stream().map(str->str.chars().mapToObj(ch->(char)ch).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toList());
     * */

    private static void countOfEachCharacter(){

        String s = "STRING DATA TO COUNT EACH CHARACTER";

        String[] s1 = s.toLowerCase().split(" ");
        List<String> stringList = Arrays.stream(s1).collect(Collectors.toList());

        List<Character> characters = stringList.stream()
                .map(str -> str.chars().mapToObj(ch -> (char)ch)
                        .collect(Collectors.toList()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Map<Character,Long> characterLongMap = characters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        characterLongMap.forEach((k,v) -> System.out.print(" KEY: "+k+" VALUE: "+v+", "));
    }

    /**
     * Write a Program to find the Maximum element in an array?
     * @Arrays.stream(array).max(Comparator.comparing(Integer::intValue)).get()
     * */

    private static void findTheMaxElement(){

        Integer[] array = {12,19,20,88,00,9};
        Integer value = Arrays.stream(array).max(Comparator.comparing(Integer::intValue)).get();
        System.out.println();
        System.out.println("FIND THE MAXIMUM ELEMENT IN AN ARRAY: "+value);
    }

    /**
     * How to find only duplicate elements with its count from the String ArrayList in Java8?
     * @Important
     * */

    private static void findDuplicateElement(){

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> map = names.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry-> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println("FIND ONLY DUPLICATE ELEMENTS WITH ITS COUNT FROM THE STRING ARRAYLIST");
        System.out.println(map);
    }

    /**
     * How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
     * @SEE
     * */

    private void checkListIsEmpty(){

        List<Notes> notes = new ArrayList<>();

        Optional.ofNullable(notes).orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                .stream().filter(Objects::nonNull) //loop through each object and consider non-null objects
                .map(note -> note.getNote())    // method reference, consider only tag name
                .forEach(System.out::println);   // it will print tag names
    }
    class Notes implements Serializable {

        private String note;

        public Notes(String note) {
            this.note = note;
        }

        public String getNote() {
            return note;
        }
    }

    /**
     * How to count each element/word from the String ArrayList in Java8?
     * @SEE
     * */

    private static void eachElementCount(){

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> longMap = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("COUNT EACH ELEMENT/WORD FROM THE STRING ARRAYLIST");
        System.out.println(longMap);
    }

    /**
     * How to use map to convert object into Uppercase in Java 8?
     * @SEE
     * */

    private static void convertObjectUpperCase(){

        List<String> names = Arrays.asList("aa", "bb", "cc", "dd");
        List<String> upperCase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("CONVERT OBJECT INTO UPPERCASE");
        System.out.println(upperCase);
    }

    /**
     * How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order
     * @Important
     * */

    private void storedInSortedOrder(){

        List<Note> noteList = new ArrayList<>();
        noteList.add(new Note(1, "note1", 11));
        noteList.add(new Note(2, "note2", 22));
        noteList.add(new Note(3, "note3", 33));
        noteList.add(new Note(4, "note4", 44));
        noteList.add(new Note(5, "note5", 55));
        noteList.add(new Note(6, "note4", 66));

        Map<String,Integer> notesRecords = noteList.stream()
                .sorted(Comparator.comparing(Note::getTagId).reversed())
                .collect(Collectors.toMap(Note::getName,Note::getTagId,(oldValue,NewValue) -> oldValue,LinkedHashMap::new));

        System.out.println("CONVERT A LIST OF OBJECTS INTO A MAP BY CONSIDERING DUPLICATED KEYS AND STORE THEM IN SORTED ORDER");
        System.out.println(notesRecords);
    }

    class Note{

        private Integer id;
        private String name;
        private Integer tagId;

        public Note(Integer id, String name, Integer tagId) {
            this.id = id;
            this.name = name;
            this.tagId = tagId;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Integer getTagId() {
            return tagId;
        }
    }

    /**
     * Write a Java 8 program to sort an array and then convert the sorted array into Stream?
     * @SEE
     * */

    private static void convertTheSortedArray(){

        int array[] = { 99, 55, 203, 99, 4, 91 };
        System.out.println("SORT AN ARRAY AND THEN CONVERT THE SORTED ARRAY INTO STREAM");
        Arrays.stream(array).sorted().forEach(System.out::println);
    }

    /**
     * Java 8 program to perform cube on list elements and filter numbers greater than 50.
     * @SEE
     * */

    private static void performCubeOnList(){

        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
        List<Double> performCube = integerList.stream().map(n -> Math.pow(n,3))
                .filter(value -> value >= 50)
                .collect(Collectors.toList());

        System.out.println("PERFORM CUBE ON LIST ELEMENTS AND FILTER NUMBERS GREATER THAN 50");
        System.out.println(performCube);
    }

    /**
     * Write a Java 8 program to concatenate two Streams?
     * @SEE
     * */

    private static void concatenateStream(){

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        List<String> stringList = Stream.concat(list1.stream(),list2.stream()).collect(Collectors.toList());
        System.out.println("CONCATENATE TWO STREAMS");
        System.out.println(stringList);
    }

    /**
     * Given a list of integers, sort all the values present in it using Stream functions?
     * @SEE
     * */

    private static void sortingAsAscOrder(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> sortedOrder = myList.stream().sorted().collect(Collectors.toList());

        System.out.println("SORT ALL THE VALUES PRESENT IN IT USING STREAM FUNCTIONS");
        System.out.println(sortedOrder);
    }

    /**
     * Given a list of integers, sort all the values present in it in descending order using Stream functions
     * @SEE
     * */

    private static void sortingAsDescOrder(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        List<Integer> descOrderList = myList.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());

        System.out.println("SORT ALL THE VALUES PRESENT IN IT IN DESCENDING ORDER USING STREAM FUNCTIONS");
        System.out.println(descOrderList);
    }

    /**
     * Given an integer array num, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * @Arrays.stream(array1).boxed().collect(Collectors.toList())
     * @Important
     * */

    private static void appearsRepeatedValue(){

        int[] array1 = {1,2,3,1};
        List<Integer> integerList = Arrays.stream(array1).boxed().collect(Collectors.toList());

        Set<Integer> set = new HashSet<>();

        Boolean v = integerList.stream()
                .anyMatch(entry -> !set.add(entry));

        System.out.println("RETURN TRUE IF ANY VALUE APPEARS AT LEAST TWICE IN THE ARRAY, AND RETURN FALSE IF EVERY ELEMENT IS DISTINCT");
        System.out.println(v);
    }

    /**
     * Given a String, find the first repeated character in it using Stream functions?
     * @IMPORTANT
     * @SEE***
     * */

    private static void findFirstRepeatedCharacter(){

        String input = "Java Articles are Awesome";

        String[] array = input.toLowerCase().split(" ");
        List<Character> characterList = Arrays.stream(array)
                .map(str-> str.chars()
                        .mapToObj(ch-> (char)ch).collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Optional<Character> finalResult = characterList.stream()
                        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                        .entrySet()
                .stream()
                        .filter(entry-> entry.getValue() > 1L)
                                .map(Map.Entry::getKey)
                                        .findFirst();

        System.out.println("GIVEN A STRING, FIND THE FIRST REPEATED CHARACTER IN IT USING STREAM FUNCTIONS");
        System.out.println(finalResult.get());
    }

    /**
     * Given a String, find the first non-repeated character in it using Stream functions?
     * @Important
     * */

    private static void findFirstNonRepeatedCharacter(){

        String input = "Java articles are Awesome";

        String[] array = input.toLowerCase().split(" ");
        List<Character> characterList = Arrays.stream(array)
                .map(str -> str.chars().mapToObj(ch -> (char)ch).collect(Collectors.toList()))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        Character result = characterList.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry-> entry.getValue() == 1L)
                .map(e-> e.getKey())
                .findFirst()
                .get();

        System.out.println("GIVEN A STRING, FIND THE FIRST NON-REPEATED CHARACTER IN IT USING STREAM FUNCTIONS");
        System.out.println(result);
    }

    /**
     * Given a list of integers, find the maximum value element present in it using Stream functions?
     * @stream().max(Comparator.comparing(Integer::intValue)).get()
     * */

    private static void findMaximumValue(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Integer maxValue = myList.stream().max(Comparator.comparing(Integer::intValue)).get();
        System.out.println("FIND THE MAXIMUM VALUE ELEMENT PRESENT IN IT USING STREAM FUNCTIONS");
        System.out.println(maxValue);
    }

    /**
     * Given a list of integers, find the total number of elements present in the list using Stream functions?
     * */

    private static void totalNumberOfElement(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        long count = myList.stream().count();
        System.out.println("THE TOTAL NUMBER OF ELEMENTS PRESENT IN THE LIST: "+count);
    }

    /**
     * Given the list of integers, find the first element of the list using Stream functions?
     * */

    private static void findTheFirstElement(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Integer value = myList.stream().findFirst().get();

        System.out.println("FIND THE FIRST ELEMENT OF THE LIST: "+value);
    }

    /**
     * Given a list of integers, find out all the numbers starting with 1 using Stream functions?
     * @myList.stream().map(value->value+"").filter(v->v.startsWith("1")).forEach(System.out::println);
     * @Important
     * */

    private static void findOutAllTheNumbers(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        System.out.println("FIND OUT ALL THE NUMBERS STARTING WITH 1");
        myList.stream().map(value-> value+"").filter(v->v.startsWith("1")).forEach(System.out::println);
    }

    /**
     * How to find duplicate elements in a given integers list in java using Stream functions?
     * @Important
     * */

    private static void findDuplicateElements(){

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        System.out.println("FIND DUPLICATE ELEMENTS IN A GIVEN INTEGERS LIST IN JAVA");
        myList.stream().filter(value-> !set.add(value)).forEach(System.out::println);
    }

    /**
     * @Important
     * @stream().collect(Collectors.groupingBy(String::length))
     * */
    private static void findTheSameLengthInString(){

        List<String> stringList = Arrays.asList("apple","banana","pear","grape");
        Map<Integer,List<String>> map = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(map);
    }
}