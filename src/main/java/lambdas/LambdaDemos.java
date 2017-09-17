package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

public class LambdaDemos {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList();
        List<Integer> allInts = Stream.of(l1, l2, l3).flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println("allInts = " + allInts);
        allInts.stream().forEach(System.out::print);

        Stream<Integer> s = Stream.of(1);
        IntStream intStream = s.mapToInt(x -> x);
        DoubleStream doubleStream = s.mapToDouble(x -> x);
        LongStream longStream = s.mapToLong(x -> x);

        Stream<Long> s2 = Stream.of(1L);
        IntStream intStream1 = s2.mapToInt(x -> x.intValue());

        DoubleStream dstream = DoubleStream.of(1.3, 4.2);
        IntStream intStream2 = dstream.mapToInt(x -> {
            Double d = x;
            int i = d.intValue();
            return i;
        } );

    }

    private static List<String> sort(List<String> list) {
        List<String> copy = new ArrayList<>(list);
        Collections.sort(copy, (a, b) -> b.compareTo(a));
        return copy;
    }
}
