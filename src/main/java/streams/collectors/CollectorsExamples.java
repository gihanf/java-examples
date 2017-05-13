package streams.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsExamples {

    public static void main(String[] args) {
        IntStream numbers = IntStream.of(1, 2, 3, 4);
        Stream<Integer> boxedIntegers = numbers.boxed();

        /** partitionedBy is a collectors method: Collectors.partitionedBy **/
        Map<Boolean, Set<Integer>> partitionedByEvenOdd = boxedIntegers.collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.toSet()));
        System.out.println("partitioned = " + partitionedByEvenOdd);

        /** groupingBy is a collectors method: Collectors.groupingBy **/
        Stream<String> stringStream = Stream.of("Peter", "Mahendar", "Robbie", "StinkyPete", "gihan", "Daniel", "melcar");
        Map<Integer, List<String>> grouped = stringStream.collect(Collectors.groupingBy(String::length));
        System.out.println("grouped = " + grouped);
    }
}
