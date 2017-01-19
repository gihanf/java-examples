package gotcha;

public class JavaNotes {
    private String someString;

    /*
    Get this class to read all the files in this project and print out all the notes which are delimited in a special way

    - identifiers can be numbers, letters, or '$' or '_'. May not start with numbers
    - switch statement can take all primitives and wrappers EXCEPT long, float, double, boolean
    - within the initialisation clause of a for loop, variables MUST be same type
    - Matching params order
        primitive
        larger primitive
        wrapper

    - Order of initilisation
        static declarations

        static initializers
        member declarations
        member initializers
        constructor
    - The for-each statement only works for Collection objects. This will not work on array objects
    - do - while loop requires a ';' after the while condition
    - substring(int beginIndex, int endIndexNotInclusive)
    - StringBuilder.equals() checks whether the referecnes are the same
        Constructors: StringBuilder(), StringBuilder(int capacity), StringBuilder(CharSequence s)

    - Arrays
        int[] numbers2 = {42, 55, 99};
        int[] numAnimals;
        int [] numAnimals2;
        int numAnimals3[];
        int numAnimals4 [];

        String[] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length);    // 3
        System.out.println(mammals[0]);    // monkey
        System.out.println(mammals[1]);    // chimp
        System.out.println(mammals[2]);    // donkey

        Arrays have .length to see how many elements in the array
    - Sorting Arrays
        Numbers sort before letters and uppercase sorts before lowercase
        (numbers -> capital letters -> lowercase letters)

        Binary Search
        Negative value showing one smaller than the negative of index, where a match needs to be inserted to preserve sorted order
        Two arrays with the same content are not equal! only equal if they refer to the same thing

     - ArrayList
        ArrayList has size() to get number of elements in the list

        equals() - See if two lists have the same elements in the same order. Therefore two ArrayLists with the same content are equal

     - Converting between primitive and wrapper classes
        valueOf()   : returns the primitive value
        parseInt(1) : returns the Wrapper class, e.g. Integer

        String number = "2";
        int a = Integer.valueOf(number);
        Integer b = Integer.parseInt(number);

     - Converting between Array and List
        (arrayList-instance).toArray()
        Arrays.asList(your array)

        Converting from an array to a List is more interesting. The original array and created array backed List are linked.

     - Date and Time
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);
        LocalDate date3 = LocalDate.of(2015, 250) // day of year

     - Static v.s Instance
        Static members can only call other static members (variables and methods). They cannot call instance members

     - Overriding Rules
        1. The method in the child class must have the same signature as the method in the parent class.
        2. The method in the child class must be at least as accessible or more accessible than the method in the parent class.
        3. The method in the child class may not throw a checked exception that is new or broader than the class of any exception thrown in the parent class method.
        4. If the method returns a value, it must be the same or a subclass of the method in the parent class, known as covariant return types.

     - Abstract classes
        Abstract classes are public
        Abstract classes may contain zero methods
        An abstract class can contain implemented methods
        An abstract method can only be declared in an abstract class
        Abstract methods are not allowed to be private or final. Protected and default access are fine

     - Interfaces
        Interface classes can be public or default level
        Interface methods are assumed abstract and public
        Variables in interfaces are assumed to be public, static, final
        An interface may extends multiple interfaces
        Since Java 8 you can have static methods in interfaces

     - Overriding v.s Hiding
        Overriding a method = a child method replaces the parent method in calls defined in both the parent and child
        Hiding method = hidden methods only replace parent methods in the calls defined in the child class
     */
}
