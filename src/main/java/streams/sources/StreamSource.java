package streams.sources;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class StreamSource {

    Stream<String> empty = Stream.empty();
    Stream<Integer> singleElement = Stream.of(1);
    Stream<Integer> fromArray = Stream.of(1, 2, 3);

    List<String> list = Arrays.asList("a", "b", "c");
    Stream<String> fromList = list.stream();
    Stream<String> fromListParallel = list.parallelStream();

    /** Creates an infinite stream of Doubles **/
    Stream<Double> randoms = Stream.generate(Math::random);

    /** Also creates an infinite stream **/
    Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);

    public static void main(String[] args) {
        Stream<String> stream = Stream.iterate("", (s) -> s + "1");

        System.out.println(Stream.iterate(1, x -> x++)
                .limit(5)
                .map(x -> "" + x)
                .collect(Collectors.joining()));

        Stream<Integer> iterate = Stream.iterate(1, x -> x * x);

        IntStream blah = IntStream.generate(() -> 1);
        IntStream blah2 = IntStream.of(1, 2, 3, 4);

        Stream<Integer> boxedIntegers = blah2.boxed();
        Map<Boolean, List<Integer>> results = boxedIntegers.collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("results = " + results);

        Stream<String> words = Stream.of("ab", "asd", "g");

        IntStream iStream = IntStream.of(1, 2, 3, 4);
        DoubleStream dstream = DoubleStream.of(1.2, 1.4, 1.6);
        LongStream lstream = LongStream.of(1, 2, 3);
    }


}
