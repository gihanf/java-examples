package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingExample {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("A", "a", "1", "1A", "1a", "11", "9");
        Collections.sort(strings);
        for (String string : strings) {
            System.out.print(string + ", ");
        }
        // 1, 11, 1A, 1a, 9, A, a


    }
}
