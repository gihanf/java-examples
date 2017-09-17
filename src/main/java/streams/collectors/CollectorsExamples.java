package streams.collectors;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectorsExamples {

    public static void main(String[] args) {
        IntStream numbers = IntStream.of(1, 2, 3, 4);
        IntStream numbers2 = IntStream.of(1, 2, 3, 4);
        Stream<Integer> boxedIntegers = numbers.boxed();
        Stream<Integer> boxedIntegers2 = numbers2.boxed();

        DoubleStream d2 = DoubleStream.of(1.2, 3.4);
        d2.peek(System.out::println).filter(value -> (value > 1.0)).count();

        Stream<String> random = Stream.of("a", "1241", "GSDG");
        random
                .peek(System.out::print)
                .forEach(System.out::println);

        /** partitionedBy is a collectors method: Collectors.partitionedBy **/
        Map<Boolean, Set<Integer>> partitionedByEvenOdd =
                boxedIntegers.collect(Collectors.partitioningBy(i -> i % 2 == 0, Collectors.toSet()));
        System.out.println("partitioned = " + partitionedByEvenOdd);

        // Overriding the resultant collection of the partition
        Map<Boolean, List<Integer>> partitionedByEvenOddList =
                boxedIntegers2.collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("partitionedList = " + partitionedByEvenOddList);

        /** groupingBy is a collectors method: Collectors.groupingBy **/
        Stream<String> teamMembers = Stream.of("peter", "mahendar", "robbie", "stinkyPete", "gihan", "daniel", "melcar", "darren");
        Map<Boolean, List<String>> groupedBy_z_asFirstLetter =
                teamMembers.collect(Collectors.groupingBy(s -> s.startsWith("z")));
        System.out.println("groupedBy_startingWithZ = " + groupedBy_z_asFirstLetter);

        Stream<String> stringStream2 = Stream.of("peter", "mahendar", "robbie", "stinkyPete", "gihan", "daniel", "melcar", "darren");
        Map<Character, List<String>> groupedBy_firstLetter =
                stringStream2.collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("groupedBy_firstLetter = " + groupedBy_firstLetter);
    }
}
