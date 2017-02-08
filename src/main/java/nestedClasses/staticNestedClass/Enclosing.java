package nestedClasses.staticNestedClass;

/** A static nested class is NOT an inner class. It is a static class defined at
 * the member level. It can be instantiated without an object of the enclosing class,
 * so it can't access the instance variables without an explicit object of the enclosing class.
 *
 * It's like a regular class except:
 * - the nesting creates a namespace because the enclosing class name must be used to refer
 * to it.
 * - Can be made private or use of the other access modifiers to encapsulate it.
 * - The enclosing class can refer to the fields and methods of the static nested class.
 * **/
public class Enclosing {
    static class Nested {
        private int price = 6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }

}
