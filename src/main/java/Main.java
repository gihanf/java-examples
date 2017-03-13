import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

import org.apache.commons.collections4.queue.CircularFifoQueue;

public class Main {

    public static void main(String[] args) {
        List<String> healthResults;
        CircularFifoQueue<String> queue = new CircularFifoQueue<>(3);
        queue.add("oldest");
        queue.add("middle");
        queue.add("youngest");

        System.out.println("Size of queue is: " + queue.size());
        System.out.println("queue = " + queue);
        System.out.println("Peek yields: " + queue.peek());

        queue.add("newbie");
        System.out.println("queue = " + queue);
        System.out.println("Peek yields: " + queue.peek());

        // Preferred way of getting newest health result
        int numResults = queue.size();
        String newestResult = queue.get(numResults - 1);

        healthResults = queue.stream().collect(Collectors.toList());
        System.out.println("newestResult = " + newestResult);
        System.out.println("healthResults = " + healthResults);

        // Worse way of getting most recent health result
        Collections.reverse(healthResults);

        TreeSet<String> tree = new TreeSet<>();
        tree.add("one");
        tree.add("One");
        tree.add("ONE");
        System.out.println("tree = " + tree);
        System.out.println(tree.ceiling("On"));

        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        m.put(4l, "asd");
        System.out.println("m = " + m);
        System.out.println(m.keySet());

    }
}
