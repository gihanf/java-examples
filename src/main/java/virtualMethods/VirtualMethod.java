package virtualMethods;

public class VirtualMethod {

    abstract class Animal {
        String name = "???";
        public void printName() {
            System.out.println(name);
        }

        public void careFor() {
            play();
        }

        public void play() {
            System.out.println("pet animal");
        }
    }

    class Lion extends Animal {
        String name = "Leo";

        public void play() {
            System.out.println("toss in meat");
        }
    }

    public static void main(String[] args) {
        Animal animal = new VirtualMethod().new Lion();

        /** Note that in this case the variable 'name' was  resolved from the superclass **/
        animal.printName();         // prints ???

        /** With virtual method invocation, Java looks up the actual type of the abstract class and calls its
         * equivalent method. Instance variables don't work this way (as seen in this example) **/

        animal.careFor();
    }
}
