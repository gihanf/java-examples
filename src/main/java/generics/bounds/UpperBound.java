package generics.bounds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBound {

    // Write a method that adds up the total of a list of numbers
    ArrayList<Number> list = new ArrayList();
    public static long total(List<Number> numbers) {
        return numbers.stream().reduce(0L,
                (number, number2) -> number.longValue() + number2.longValue()).longValue();

    }

    ArrayList<? extends Number> upperBoundedList = new ArrayList<Integer>();
    public static long betterTotal(List<? extends Number> numbers) {
        long total = 0L;
        for (Number b : numbers) {
            total += b.longValue();
        }
        return total;
    }

    static class Sparrow extends Bird {}
    static class Bird {}

    interface Flyer {
        void fly();
    }

    class Hanglider implements Flyer { public void fly() {}}
    class Goose implements Flyer { public void fly() {}}

    private void anyFlyer(List<Flyer> flyer) {}
    private void groupOfFlyers(List<? extends Flyer> flyer) {}

    /** Interfaces and upper bounds **/
    // A list of type List<Goose> can only be passed to groupOfFlyers. Cannot pass this to anyFlyer

    public static void main(String[] args) {
        List<Number> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3);
        long total = total(numbers1);
        System.out.println("numbers1 total = " + total);
        // System.out.println("numbers2 total = " + total(numbers2));   Does not compile

        // Using generics
        List<Double> numbers3 = Arrays.asList(1.0, 2.1, 3.1);
        List<Float> numbers4 = Arrays.asList(1f, 2f, 3f);
        List<Integer> numbers5 = Arrays.asList(2, 4, 6);
        System.out.println("total(numbers3) = " + betterTotal(numbers3));
        System.out.println("total(numbers4) = " + betterTotal(numbers4));
        System.out.println("total(numbers5) = " + betterTotal(numbers5));

        /** When we work with upper bounds or unbounded wildcards, lists become immutable **/
        List<? extends Bird> birds = new ArrayList<Bird>();
        //birds.add(new Sparrow());     //DOES NOT COMPILE
        //birds.add(new Bird());        //DOES NOT COMPILE


    }
}
