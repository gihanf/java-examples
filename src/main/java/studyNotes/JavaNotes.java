package studyNotes;

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

    - Enums
        semi-colon ; is required at the end of the list when each enum has an associated attribute(s)
        A constructor is required and it cannot be anything other than private. 'private' is redundant

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

        Virtual method invocation says that the subclass method gets called at runtime rather than the type in the variable reference.
        However, when referring to instance variables, the reference type does matter.

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

     - Chapter 2 Design Patterns and Principles
        Singleton pattern
            - constructor must be private
            - public static method to retrieve instance, e.g. getInstance()
            - typically uses lazy initialisation

        Immutable objects
            - Don't have any setter methods
            - Members are marked private and final
            - Methods are marked final as to not be overridden
            - Make copies of objects rather than give callers direct access to members
            - The class is marked final

        Functional Interfaces - contain only one abstract method (default methods count)

     - Chapter 9 IO
        Difference between IO and NIO2

        Streams API uses depth-first searching (as opposed to breadth first searching) with max depth Integer.MAX_VALUE

        Files.walk() is used to traverse a filesystem using streams. It will not follow symbolic links
        Files.find(path, intdepth, bipredicate) allows you to search a directory

        Files.list(path) to list the contents of the directory

        Files.readAllLines() - reads all the lines of a path into memory.. dangerous if file is large
        Files.lines() - creates a Stream<String> allowing you to traverse the contents in a functional way and not suffer from OOM errors

        BasicFileAttributeView can be used to modify file attributes, e.g. setTimes(creation, modify, updated)
        BasicFileAttributes can only be used to VIEW file attributes

        path.resolve(Path), appends the paths together. However! when the path being resolved is absolute, it the one returned
        path.toRealPath() actually checks that there is a real file related to this path object

        Files.isSameFile(p1, p2) returns true if the files pointed to in the filesystem are the same, without regard to the contents

        NIO2 advantages over legacy java.io.file
        supports file system dependent attributes
        allows you to traverse a directory tree directly
        support symbolic links

     Chapter 10 - JDBC
     JDBC Java Database Connectivity
     ORM Object Relational Mapping
     SQL Structured Query Language

     4 Main interfaces in JDBC
     Driver     - knows how to get a connection to the database
     Connection - knows how to communicate with the database
     Statement  - knows how to run sql
     ResultSet  - knows what was returned by a SELECT query

     Vendors (e.g. mysql, oracle) will implement these interfaces. They become available as a jar. When executing a
     program this jar needs to be on the classpath)

     JDBC url format

     jdbc:postgres://localhost:5300/zoo
     <protocol>:<vendor>:<datbase-specific-connection-details>

     Connection
     Two ways to get a connection to the database
     - DatabaseManager (this course)
     - DataSource (what we use in industry)

     Statement
     Two ways to get a statment
     Statement stmt = connection.createStatement()

     Statement stmt = connection.createStatment(
                        ResultSet.TYPE_FORWARD_ONLY - TYPE_FORWARD_ONLY / TYPE_SCROLL_SENSITIVE / TYPE_SCROLL_INSENSITIVE
                        ResultSet.CONCUR_READ_ONLY - CONCUR_READ_ONLY / CONCUR_UPDATEABLE

     TYPE_FORWARD_ONLY - default. Can go through data in the order in which it is retrieved
     TYPE_SCROLL_SENSITIVE - Allow going through data in any order. Result set changes when changes made to the db
     TYPE_SCROLL_INSENSITIVE - Allow going through data in any order. Result set doesn't change when db changes

     CONCUR_READ_ONLY - cannot modify the db using the ResultSet
     CONCUR_UPDATEABLE - allows modification of db via ResultSet

     Executing Statments
     executeUpdate() - DELETE, INSERT, UPDATE, return type int
     executeQuery() SELECT, return type ResultSet
     execute() - SELECT, INSERT, UPDATE, DELETE, returns a boolean to tell you whether there is a ResultSet

     Reading ResultSet
     rs.next()
     rs.getInt('columnName' or columnIndex)
     rs.getString('columnName' or columnIndex)
     rs.getTime
     rs.getTimeStamp

     JDBC starts counting index from 1 not 0

     ResultSet          Return type
     rs.next()          boolean
     rs.previous()      boolean
     rs.beforeFirst()   void
     rs.first()         boolean
     rs.last()          boolean
     rs.afterLast()     void
     rs.absolute(int)   boolean
     rs.relative(int)   boolean

     Every method apart from next() requires a SCROLLABLE ResultSet

     JDBC automatically closes ResultSet when you run another SQL from the same Statement object

     SQLExceptions
     e.getMessage() - human readable
     e.getSQLState() - returns a code as to what went wrong
     e.getErrorCode() - returns database specific code

     */
}
