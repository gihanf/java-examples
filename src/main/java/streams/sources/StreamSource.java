package streams.sources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

}
