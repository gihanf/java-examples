package overriding;


public class BirdDemo {

    public abstract class Bird {
        private void fly() {
            System.out.println("Bird is flying");
        }
    }

    public class Pelican extends Bird {
        protected void fly() {
            System.out.println("Pelican is flying");
        }
    }

    public static void main(String[] args) {
        Bird bird = new BirdDemo().new Pelican();
        bird.fly();     // "Bird is flying"

        /** Because the fly() method in the Bird class is PRIVATE it can only be HIDDEN, not overridden.
         * The reference is of type Bird, so the private fly() is called and java doesn't look for overridden
         * methods because it can't. **/
    }
}
