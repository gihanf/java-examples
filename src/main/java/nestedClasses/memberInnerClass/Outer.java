package nestedClasses.memberInnerClass;

/** Member inner classes are named classes defined at the field level of a class
 * They:
 * - Can be declared public, private, protected or use default access
 * - Can extend any class and implement interfaces
 * - Can be abstract or final
 * - Cannot declare static fields or methods
 * - Can access members of the outer class including private members
 * **/
public class Outer {
    /** Compiling inner classes will produce class files like Outer$Inner.class **/
    private String greeting = "Hello";

    private class Inner {
        private int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) {
        Outer outer = new Outer();

        /** Initialise inner classes like this
         * outer.new Inner() **/
        Inner inner = outer.new Inner();
        inner.go();

        System.out.println("I can see inner vars " + inner.repeat);
    }
}
