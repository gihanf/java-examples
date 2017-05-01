package collections.queues;


import java.util.ArrayDeque;

public class QueueDemo {

    public static void main(String[] args) {
        ArrayDeque<Integer> haircutNumbers = new ArrayDeque<>();
        haircutNumbers.add(2);
        haircutNumbers.add(4);
        haircutNumbers.add(6);

        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.element() = " + haircutNumbers.element());
        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.peek() = " + haircutNumbers.peek());
        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.pop() = " + haircutNumbers.pop());
        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.poll() = " + haircutNumbers.poll());
        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.add(1) = " + haircutNumbers.add(1));
        System.out.println("haircutNumbers = " + haircutNumbers);

        System.out.println("haircutNumbers.push(3)");
        haircutNumbers.push(3);
        System.out.println("haircutNumbers = " + haircutNumbers);
    }
}
