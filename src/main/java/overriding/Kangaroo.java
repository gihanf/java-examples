package overriding;

public class Kangaroo extends Marsupial {
    public boolean isBiped() {
        return true;
    }
    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: "+isBiped());
    }
    public static void main(String[] args) {
        Marsupial joey = new Marsupial();
        joey.getMarsupialDescription();
//        joey.getKangarooDescription();
    }
}