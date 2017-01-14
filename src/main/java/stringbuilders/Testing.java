package stringbuilders;

public class Testing {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("meow");
        StringBuilder s2 = new StringBuilder("meow");

        if (s1.equals(s2)) {
            System.out.println("Were the same");
        }

        if (s1.toString() == "meow") {
            System.out.println("were the same via ==");
        }

        if ("meow" == "meow") {
            System.out.println("Afsa");
        }
        System.out.println("Contents of s1 " + s1.toString());
        System.out.println("Contents of s2 " + s2.toString());
        System.out.println("Printing the sb " + s1);
        System.out.println("Are they equal via equals()? " + s1.equals(s2));
        System.out.println("Are they equal via == " + (s1 == s2));
    }
}
