package collections;

import java.util.ArrayList;
import java.util.List;

public class CommonCollections {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        System.out.println("numbers = " + numbers);
        numbers.remove(new Integer(2));

        System.out.println("After deleting");
        System.out.println("numbers = " + numbers);
    }
}
