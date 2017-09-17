package lambdas.functionalInterfaces;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {

        /* Supplier Examples **/
        Supplier<LocalDate> s1 = () -> LocalDate.now();
        Supplier<LocalDate> s2 = LocalDate::now;

        /* Consumer & BiConsumer **/
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = System.out::println;

        Map<String, Integer> map = new HashMap();
        BiConsumer<String, Integer> bc = (str1, int1) -> map.put(str1, int1);
        BiConsumer<String, Integer> bc2 = map::put;

        /* Predicate & BiPredicate **/
        Predicate<String> p1 = someString -> someString.isEmpty();
        Predicate<String> p2 = String::isEmpty;

        BiPredicate<String, String> bp1 = (str1, str2) -> str1.startsWith(str2);
        BiPredicate<String, String> bp2 = String::startsWith;

        /* Function & BiFunction **/
        Function<String, Integer> f1 = (s) -> s.length();
        Function<String, Integer> f2 = String::length;

        BiFunction<String, String, String> bf1 = (st1, st2) -> st1.concat(st2);
        BiFunction<String, String, String> bf2 = String::concat;

        /* UnaryOperator & BinaryOperator */
        UnaryOperator<String> u1 = (s) -> s.toUpperCase();
        UnaryOperator<String> u2 = String::toUpperCase;

        BinaryOperator<String> b1 = (bs1, bs2) -> bs1.concat(bs2);
        BinaryOperator<String> b2 = String::concat;

    }
}
