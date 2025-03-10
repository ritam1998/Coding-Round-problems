package streams;

import java.io.Serializable;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsInterviewPrograms {

    public static void main(String[] args) {

        findEvenAndOddUsingStream();
        frequencyOfEachWord();
        findKthSmallest();
        removedDuplicatesList();
        intersectionsOfTwoList();
        mergedTwoSortedStream();
        checkPrimeNumber();
        longestStringInList();

        findAllNonDuplicateValue();
        findAllPairsOfNumbers();
        occurrencesOfAGivenCharacter();
        findAllAnagrams();
        productOfTwoIntegers();
        medianOfIntegers();
        longestCommonPrefix();
        generateFibonacciSeries();

        setUpperCase();

        StreamsInterviewPrograms streamsInterviewPrograms = new StreamsInterviewPrograms();
        streamsInterviewPrograms.sumOfTransactionAmount();
        streamsInterviewPrograms.calculateAverageAge();
    }

    /**
     * Implement a method to partition a list into two groups based on a predicate using Java streams:
     * Find the even & odd numbers in array using stream.
     * @Collect(Collectors.partitioningBy(Predicate))
     * */

    private static void findEvenAndOddUsingStream(){

        List<Integer> list = List.of(1,4,2,9,5,6,8,7,15,18,14,20,12);
        Predicate<Integer> predicate = a -> a%2 == 0;
        Map<Boolean,List<Integer>> booleanListMap = list.stream().collect(Collectors.partitioningBy(predicate));

        List<Integer> evenList = booleanListMap.get(true);
        List<Integer> oddList = booleanListMap.get(false);

        System.out.println("ODD LIST: "+oddList);
        System.out.println("EVEN LIST: "+evenList);
    }

    /**
     * Given a list of strings, find the frequency of each word using Java streams:
     * @collect(Collectors.groupingBy(Function,Collectors))
     * @collect(Collectors.groupingBy(Function,Supplier,Collectors))
     * @collect(Collectors.groupingBy(Function))
     */

    private static void frequencyOfEachWord(){

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");

        Function<String,String> stringStringFunction = Function.identity();
        Map<String,Long> stringLongMap = words.stream().collect(Collectors.groupingBy(stringStringFunction,Collectors.counting()));

        stringLongMap.forEach((k,v)-> System.out.println("KEY: "+k+" VALUE: "+v));
    }

    /**
     * Find the kth the smallest element in an array using Java streams:
     * @distinct().sorted().findFirst().orElse()
     */

    private static void findKthSmallest(){

        List<Integer> list = List.of(1,4,2,9,5,6,8,7,15,18,14,20,12);
        int k = 1;

        Integer value = list.stream().distinct()
                .sorted()
                .skip(k-1)
                .findFirst()
                .orElse(-1);

        System.out.println("KTH ELEMENT: "+value);
    }

    /**
     * Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
     * @collect(Collectors.groupingBy(Functions,Collectors.summingInt()))
     * */

    private void sumOfTransactionAmount(){

        List<Transactions> transactionsList = List.of(
                new Transactions("2022-01-01", 100),
                new Transactions("2022-01-01", 200),
                new Transactions("2022-01-02", 300),
                new Transactions("2022-01-02", 400),
                new Transactions("2022-01-03", 500)
        );

        Function<Transactions,String> transactionsFunction = Transactions::getDate;

        Map<String,Integer> stringIntegerMap = transactionsList.stream()
                .collect(Collectors.groupingBy(transactionsFunction,Collectors.summingInt(Transactions::getAmount)));

        stringIntegerMap.forEach((k,v) -> System.out.println("DATE: "+k+" & SUM: "+v));
    }

    class Transactions implements Serializable {

        private String date;
        private Integer amount;

        public Transactions(String date, Integer amount) {
            this.date = date;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public Integer getAmount() {
            return amount;
        }
    }

    /**
     * Remove duplicates from a list while preserving the order using Java streams:
     * @distinct().collect(Collectors.toList())
     * */

    private static void removedDuplicatesList(){

        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> removedDuplicates = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());

        System.out.println("REMOVED DUPLICATES: "+removedDuplicates);

        List<Integer> sortDesc = removedDuplicates.stream().sorted((a,b) -> b-a).collect(Collectors.toList());
        System.out.println("DESC ORDER: "+sortDesc);
    }

    /**
     * Find the intersection of two lists using Java streams:
     * @filter(Predicate).collect(Collectors.toList())
     * */

    private static void intersectionsOfTwoList(){

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

        Predicate<Integer> predicate = list2::contains;
        List<Integer> integerList = list1.stream().filter(predicate).collect(Collectors.toList());

        System.out.println("INTERSECTION LIST: "+integerList);
    }

    /**
     * Merge two sorted lists into a single sorted list using Java streams:
     * @Stream.concat(list1.stream(),list2.stream()).sorted().collect(Collectors.toList())
     */

    private static void mergedTwoSortedStream(){

        List<Integer> list1 = new ArrayList<>(List.of(1, 3, 5, 7, 9));
        List<Integer> list2 = List.of(2, 4, 6, 8, 10);

        list1.addAll(list2);

        List<Integer> mergedListUsingAddAll = list1.stream().sorted().collect(Collectors.toList());
        System.out.println("MERGE LIST USING ADD ALL: "+mergedListUsingAddAll);

        List<Integer> list3 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list4 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> mergedListUsingStream = Stream.concat(list3.stream(),list4.stream()).sorted().collect(Collectors.toList());
        System.out.println("MERGE LIST USING STREAM: "+mergedListUsingStream);
    }

    /**
     * Check if a list of integers contains a prime number using Java streams:
     * @stream().anyMatch(predicate) #see will return @Boolean Value
     * @stream().filter(predicate).collect(Collectors.toList())
     * */

    private static void checkPrimeNumber(){

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);

        Predicate<Integer> predicate = n -> {
            if(n <= 1)
                return false;

            for(int i=2; i< n/2;i++){
                if(n%i == 0)
                    return false;
            }
            return true;
        };

        boolean primeNumbers = numbers.stream().anyMatch(predicate);
        System.out.println("PRIME NUMBER IS PRESENT IN LIST: "+primeNumbers);

        List<Integer> findPrimeNumbersInList = numbers.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("FIND PRIME NUMBERS IN LIST: "+findPrimeNumbersInList);
    }

    /**
     * Calculate the average age of a list of Person objects using Java streams:
     * @stream().mapToInt(Person::getAge).average().orElse(0)
     * */

    private void calculateAverageAge(){

        List<Person> persons = List.of(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        double averageAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println("AVERAGE AGE: "+averageAge);
    }

    class Person{

        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }

    /**
     * Find the longest string in a list of strings using Java streams:
     * @stream().max(Comparator.comparing(String::length))
     * @See Given a list of strings, find the longest string using Java streams.
     * @stream().max((a, b) -> Integer.compare(a.length(),b.length()))
     * */

    private static void longestStringInList(){

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");

        Integer length = strings.stream().map(String::length).max((a, b) -> b-a).get();
        Optional<String> value = strings.stream().max(Comparator.comparing(String::length));

        System.out.println("LONGEST STRING IN LIST USING COMPARATOR: "+value.get());

        Optional<String> longestString = strings.stream().max((a, b) -> Integer.compare(a.length(),b.length()));
        System.out.println("LONGEST STRING IN LIST USING Integer.compare: "+longestString.get());
    }

    /**
    * Given a list of integers, find all non-duplicate integers using Java streams:
     * @stream().collect(Collectors.groupingBy(function,Collectors.counting()))
     * @numbers.stream().filter(integerPredicate).forEach(System.out::println);
    * */

    private static void findAllNonDuplicateValue(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 6, 4, 7, 8, 9, 9);

        Function<Integer,Integer> function = Function.identity();
        Map<Integer,Long> integerMap = numbers.stream().collect(Collectors.groupingBy(function,Collectors.counting()));

        Predicate<Integer> integerPredicate = n -> integerMap.get(n) == 1;
        numbers.stream().filter(integerPredicate).forEach(System.out::println);
    }

    /**
     * Given a list of integers, find all pairs of numbers that sum up to a given target using Java streams:
     * @filter(s -> !s.isEmpty()).collect(Collectors.toSet())
     * @flatMap(i -> numbers.stream().map(j-> i+j == target? "("+i+j+")" : ""))
     * */

    private static void findAllPairsOfNumbers(){

        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int target = 12;

        Set<String> findAllPairs = numbers.stream()
                .flatMap(i -> numbers.stream().map(j-> i+j == target? "("+i+j+")" : ""))
                .filter(s -> !s.isEmpty()).collect(Collectors.toSet());
        System.out.println("PAIRS THAT SUM UP TO " + target + ": " + findAllPairs);
    }

    /**
     * Find the number of occurrences of a given character in a list of strings using Java streams:
     * @stream().flatMapToInt(CharSequence::chars).filter(s-> s==target).count()
     * */

    private static void occurrencesOfAGivenCharacter(){

        List<String> strings = Arrays.asList("apple", "banana", "orange","grape", "melon");
        char target = 'a';

        long value = strings.stream().flatMapToInt(CharSequence::chars).filter(s-> s==target).count();
        System.out.println("OCCURRENCES OF '" + target + "': " + value);
    }

    /**
     * Implement a method to find all anagrams in a list of strings using Java streams:
     * @stream().collect(Collectors.groupingBy(function))
     * */

    private static void findAllAnagrams(){

        List<String> words = Arrays.asList("listen", "silent", "hello", "world", "night", "thing");
        Function<String,String> function = word -> {
          char[] chars = word.toCharArray();
          Arrays.sort(chars);
          return new String(chars);
        };
        Map<String,List<String>> stringMap = words.stream().collect(Collectors.groupingBy(function));
        System.out.println("ANAGRAMS ARE: ");
        stringMap.forEach((k,v) -> System.out.println("KEY: "+k+" VALUE: "+v));
    }

    /**
     * Find the maximum product of two integers in an array using Java streams:
     * @Important
     * @IntStream.range(0,array.length).mapToObj(i->IntStream.range(i+1,array.length).map(j->array[i]*array[j]).max().orElse(Integer.MIN_VALUE)).max(Integer::compare).orElse(Integer.MIN_VALUE);
     * */

    private static void productOfTwoIntegers(){

        int[] array = {1, 4, 3, 6, 2, 7, 8};

        int maxProduct = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);
        System.out.println("MAXIMUM PRODUCT: " + maxProduct);
    }

    /**
     * Find the median of a list of integers using Java streams:
     * @Important
     * */

    private static void medianOfIntegers(){

        List<Integer> numbers = Arrays.asList(5, 2, 1, 3, 4);

        Function<List<Integer>,Double> function = StreamsInterviewPrograms::findMedian;
        double v = function.apply(numbers);

        System.out.println("MEDIAN OF LIST: "+v);
    }
    public static double findMedian(List<Integer> input) {
        Collections.sort(input);
        int len = input.size();
        if (len % 2 == 1) return input.get(len / 2);
        return 0.5 * (input.get(len / 2) + input.get(len / 2 - 1));
    }

    /**
     *  Given a list of strings, find the longest common prefix using Java streams:
     * @Important
     * @stream().reduce(binaryOperator).orElse("")
     * */

    private static void longestCommonPrefix(){

        List<String> strings = Arrays.asList("flower", "flow", "flight");

        BinaryOperator<String> binaryOperator = (s1,s2) -> {
            int length = Math.min(s1.length(),s2.length());
            int i = 0;
            while(i < length && s1.charAt(i) == s2.charAt(i)){
                i++;
            }
            return s1.substring(0,i);
        };
        String value = strings.stream().reduce(binaryOperator).orElse("");
        System.out.println("LONGEST SUBSTRING: "+value);
    }

    /**
     * Implement a method to calculate the Fibonacci sequence using Java streams:
     * */

    private static void generateFibonacciSeries(){

        LongStream fibonacci = Stream.iterate(
                        new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .mapToLong(f -> f[0]);
        // Print first 10 Fibonacci numbers
        fibonacci.limit(10).forEach(System.out::println);
    }

    /**
     * Implement a method to convert first word in uppercase
     * */

    private static void setUpperCase(){

        String data = "welcome to java programming";
        List<String> stringList = Arrays.asList(data.split(" "));

        Function<String,String> function = value -> {
            return value.substring(0,1).toUpperCase(Locale.ROOT) + value.substring(1).toLowerCase();
        };

        String v = stringList.stream().map(function).collect(Collectors.joining(" "));
        System.out.println("UPPERCASE: "+v);
    }
}
