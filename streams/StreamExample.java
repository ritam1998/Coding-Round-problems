package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(2000);
        list.add(3000);
        list.add(4000);
        list.add(5000);
        list.add(6000);

        long count = list.stream().filter(sal -> sal < 3000).count();
        System.out.println("Count: "+count);

        /* 1. using filter operation: */
        Stream<String> stringStream = Stream.of("HELLO","EVERYBODY","HOW","ARE","YOU","DOING");
        List<String> stringList = stringStream.filter(s -> s.length() <= 3).collect(Collectors.toList());
        System.out.println("Filter: "+stringList);

        /* 2. using map operation: */
        Stream<String> stringStream1 = Stream.of("HELLO","EVERYBODY","HOW","ARE","YOU","DOING");
        List<String> lowerCaseList = stringStream1.map(String::toLowerCase).collect(Collectors.toList());
        System.out.println("Map: "+lowerCaseList);

        /* 3. using flatmap operation: */
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("I","LOVE","JAVA"),
                Arrays.asList("CONCEPTS","ARE","CLEAR"),
                Arrays.asList("ITS","VERY","EASY")
        );

        List<String> stringList1 = lists.stream().flatMap(s -> s.stream().map(String::toLowerCase)).collect(Collectors.toList());
        System.out.println("FlatMap: "+stringList1);

        /* 4. using distinct operation: */
        Integer[] integers = {1,2,2,3,4,5,4,2,6,7,8,6};
        Stream<Integer> integerStream = Arrays.stream(integers).distinct();

        List integers1 = integerStream.collect(Collectors.toList());
        System.out.println("Distinct: "+integers1);

        /* 5. using sorted operation: */
        Integer[] integerValue = {6,1,8,2,4,5,3,18,7};
        List sortedList = Arrays.stream(integerValue).sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());
        System.out.println("Sorted: "+sortedList);

        /* 6. using peek operation: */
        Integer peekIntegers[] = {2,3,5,7,8,9};
        List v =  Arrays.stream(peekIntegers).filter(i -> i > 2)
                .peek(i-> System.out.println(i))
                .map(i -> i * 2)
                .collect(Collectors.toList());

        System.out.println("Peek: "+v);

        /* 7. using limit operation: */

        Integer[] limitInt = {1,2,3,4,5,6};
        List<Integer> limit = Arrays.stream(limitInt).limit(3).collect(Collectors.toList());
        System.out.println("Limit: "+ Arrays.toString(limitInt));

        /* 8. using skip operation: */

        Integer[] skipInt = {1,2,3,4,5};
        List skip = Arrays.stream(skipInt).skip(3).collect(Collectors.toList());
        System.out.println("Skip: "+skip);

        /* 9. using mapToInt operation: */

        Integer[] mapT = {1,2,3,4,5};
        int[] array = Arrays.stream(mapT).mapToInt(i -> i).map(i -> i * 3).toArray();
        Arrays.stream(array).forEach(System.out::println);
    }
}
