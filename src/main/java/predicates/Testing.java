package predicates;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Testing implements Predicate<String> {

    private String color;
    public Testing(String color) {
        color = color;
    }

    public Testing() {

    }

    public static void main(String[] args) {
        Testing t = new Testing();
        System.out.println("color = " + t.color);

        String[] array;
        array = new String[]{"a", "B", "b", "aa", "1", "1a", "BB", "B1"};
        // B BB B1 a aa 1 1a
        // numbers, capital letters, letters
        List<String> strings = Arrays.asList(array);
        Collections.sort(strings);
        System.out.println(strings);

        double y = 1232.32;
        float flt = (float)y;
    }

    @Override
    public boolean test(String s) {
        return false;
    }
}
