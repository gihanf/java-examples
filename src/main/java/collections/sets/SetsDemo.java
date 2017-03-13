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
        System.out.println("Lower :" + mySet.lower(10));

        /** higher(E e) : smallest element that is > e **/
        System.out.println("Higher :" + mySet.higher(10));

        NavigableSet<Integer> example = new TreeSet<>();
        example.add(8);
        example.add(9);
        example.add(11);
        example.add(12);

        /** floor(E e) : greatest element that is <= e **/
        System.out.println("Floor :" + example.floor(10));

        /** ceiling(E e) : smallest element >= e **/
        System.out.println("Ceiling :" + example.ceiling(10));


    }

}
