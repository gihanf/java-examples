package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {
        // Lists backed by an array. Change content in one, contents of both the array and list change
        String anArray[] = {"word1", "word2", "word3"};
        List<String> arrayBackedList = Arrays.asList(anArray);
        arrayBackedList.set(0, "new word");

        System.out.println("First element of array: " + anArray[0]);
        System.out.println("First element of list: " + arrayBackedList.get(0));

        anArray[0] = "changed again";
        System.out.println("First element of array: " + anArray[0]);
        System.out.println("First element of list: " + arrayBackedList.get(0));

        // Arrays with same content are not equals, arrays with same reference are equal
        int array[] = {1, 2, 053, 4};
        int arraySameContents[] = {1, 2, 3, 4};
        int arraySameReference[] = array;
        System.out.println("Are arrays with the same content equal? - " + array.equals(arraySameContents));
        System.out.println("Are arrays that point to the same reference equal? - " + array.equals(arraySameReference));
    }
}
