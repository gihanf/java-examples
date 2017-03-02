package generics.bounds;

import java.util.ArrayList;
import java.util.List;

/**
 * Types of bounds
 * 1. UpperBound wildcard                ?                   List<?> l = new ArrayList<String>();
 * 2. Wildcard with an upper bound      ? extends type      List<? extends Exception> l = new ArrayList<RuntimeException>();
 * 3. Wildcard with a lower bound       ? super type        List<? super Exception> l = new ArrayList<Object>();
 *
 */

public class BoundsDemo {
    
    public static void printList(List<Object> list) {
        for (Object x: list) {
            System.out.println(x);
        }
    } 
    
    public static void printListCorrect(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
    
    public static void main(String[] args) {
        List<String> keywords = new ArrayList();
        keywords.add("java");
        //printList(keywords); DOES NOT COMPILE
        /** Java is trying to protect us
         * It knows that List<String> can't be assigned to List<Object>
         *
         * With arrays, this is not quite the same
         * **/
        
        Integer[] numbers = {new Integer(42)};
        Object[] objects = numbers;             // This compiles!!
        objects[0] = "forty two";               // Throws a runtime exception ArrayStoreException
        
        /** Using unbounded wildcards to avoid errors **/
        List<String> moreKeywords = new ArrayList();
        printListCorrect(moreKeywords);
    }

}
