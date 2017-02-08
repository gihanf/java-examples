package nestedClasses.localInnerClass;

/** Local inner classes are named classes that are defined within a method
 *  They:
 *  - Do not have an access specifier
 *  - Cannot be declared static and cannot declare static fields or methods
 *  - Don't have access to local variables of a method unless those methods are final
 *  or effectively final
 * **/
public class Outer {
    private int length = 5;
    public void calculate() {
        final int width = 20;
        class Inner {
            public void multiply() {
                // Inner class can access the private members of the outer class
                System.out.println(length * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.calculate();
    }

    /** Importing static inner classes via regular 'import' statement or 'import static'**/
}
