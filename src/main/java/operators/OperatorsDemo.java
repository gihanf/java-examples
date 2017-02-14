package operators;

public class OperatorsDemo {

    /**
     * `a instanceof B` returns true if the reference to which 'a' points is an:
     * - instance of class B
     * - a subclass of B (directly or indirectly)
     * - a class that implements the B interface (directly or indirectly)
     */

    class HeavyAnimal {}
    class Hippo extends HeavyAnimal {}
    class Elephant extends HeavyAnimal {}

    public interface Mother {}

    public static void main(String[] args) {
        HeavyAnimal hippo = new OperatorsDemo().new Hippo();
        boolean b1 = hippo instanceof Hippo;         // true
        boolean b2 = hippo instanceof HeavyAnimal;   // true

        /** This compilation only check only applies when 'instanceof' is called on a class **/
        // Remember that reference type of hippo is 'HeavyAnimal'
        boolean b3 = hippo instanceof Elephant;      // false

        // This time the reference type is 'Hippo'
        Hippo hippo2 = new OperatorsDemo().new Hippo();
        /** Does not compile as this time the classes are not related **/
        // boolean b4 = hippo2 instanceof Elephant;

        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object;     // false

        /** When checking whether an object is an instanceof an interface, java waits until runtime to do the check **/
        HeavyAnimal hippo3 = new OperatorsDemo().new Hippo();

        /** This does compile beacause 'Mother' is an interface.
         * Compiler allows it because later there could be a class like this:
         *      class MotherHippo extends Hippo implements Mother {} **/
        boolean b6 = hippo3 instanceof Mother;          // false

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);

        System.out.println("b5 = " + b5);
        System.out.println("b6 = " + b6);
    }
}
