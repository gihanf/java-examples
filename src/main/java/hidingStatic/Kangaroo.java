package hidingStatic;

public class Kangaroo extends Marsupial {
    public static boolean isBiped() {
        return true;
    }

    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: " + isBiped());
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        joey.getMarsupialDescription();
        joey.getKangarooDescription();
    }

    /**
     * Difference between overriding and hiding methods
     *
     * Unlike overriding a method, in which a child method replaces the parent method in calls
     * defined in both the parent and child, hidden methods only replace parent methods in the calls defined
     * in the child class.
     *
     * See example above
     * **/
}
