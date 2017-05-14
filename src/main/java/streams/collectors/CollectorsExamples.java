package streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
        Stream<String> stringStream = Stream.of("peter", "mahendar", "robbie", "stinkyPete", "gihan", "daniel", "melcar", "darren");
        Map<Boolean, List<String>> groupedBy = stringStream.collect(Collectors.groupingBy(s -> s.startsWith("z")));
        System.out.println("grouped = " + groupedBy);

        Stream<String> stringStream2 = Stream.of("peter", "mahendar", "robbie", "stinkyPete", "gihan", "daniel", "melcar", "darren");
        Map<Character, List<String>> collect = stringStream2.collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("collect = " + collect);
    }
}
