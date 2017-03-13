package streams.terminaloperators;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Terminal operations
 * allMatch(), anyMatch(), noneMatch()
 *
 * collect()
 *
 * count()
 *
 * findAny(), findFirst()
 *
 * forEach()
 *
 * min(), max()
 *
 * reduce()
 **/

public class TerminalOperator {

    public static void main(String[] args) {
        /** count requires a finite stream **/
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        System.out.println(s.count());

        /** min or max require a compator to be specified **/
        s = Stream.of("monkey", "gorilla", "ape");
        Optional<String> min = s.min((s1, s2) -> (s1.length() - s2.length()));
        min.ifPresent(System.out::println); // ape

        s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().ifPresent(System.out::println); // monkey

        List<String> list = Arrays.asList("monkey", "2", "chimp");
        infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred));   // true
        System.out.println(list.stream().allMatch(pred));   // false
        System.out.println(list.stream().noneMatch(pred));  // false
        System.out.println(infinite.anyMatch(pred));    // true

        s = Stream.of("monkey", "gorilla", "ape");
        s.forEach(System.out::println);

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s1, s2) -> s1 + s2);
        System.out.println("word = " + word);




    }
}
