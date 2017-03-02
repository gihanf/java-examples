package generics.bounds;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LowerBound {

    public static List<? super IOException> exceptions = new ArrayList<Exception>();
    public static List<Exception> exceptions2 = new ArrayList<>();
    public static List<? super Number> stuff = new ArrayList<>();

    public static void main(String[] args) {
        /** We could have a List<IOException> and an Exception object wouldn't fit in there **/
        // exceptions.add(new Exception());         // DOES NOT COMPILE,
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

        exceptions2.add(new Exception("I tried"));
        Number n = new Integer(3);
        stuff.add(new Integer(2));
        stuff.add(n);
    }
}
