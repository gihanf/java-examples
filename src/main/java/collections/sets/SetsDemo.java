package collections.sets;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Sets
 **/


public class SetsDemo {

    public static void main(String[] args) {
        NavigableSet<Integer> mySet = new TreeSet<>();
        for (int i = 1; i <= 20; i++) mySet.add(i);

        /** lower(E e) : greatest element that is < e **/
        System.out.println("Lower(10): " + mySet.lower(10));

        /** higher(E e) : smallest element that is > e **/
        System.out.println("Higher(10): " + mySet.higher(10));

        NavigableSet<Integer> exampleSet = new TreeSet<>();
        exampleSet.add(8);
        exampleSet.add(9);
        exampleSet.add(11);
        exampleSet.add(12);

        /** floor(E e) : greatest element that is <= e **/
        System.out.println("Floor(10): " + exampleSet.floor(10));

        /** ceiling(E e) : smallest element >= e **/
        System.out.println("Ceiling(10): " + exampleSet.ceiling(10));

        System.out.println("mySet.lower(10) = " + mySet.lower(10));
        System.out.println("mySet.floor(10) = " + mySet.floor(10));
        System.out.println("mySet.ceiling(10) = " + mySet.ceiling(10));
        System.out.println("mySet.higher(10) = " + mySet.higher(10));
    }

}
