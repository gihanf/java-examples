package overriding;

class Marsupial {
    public boolean isBiped() {
        return false;
    }
    public void getMarsupialDescription() {
        System.out.println("Marsupial walks on two legs: "+isBiped());
    }

    public static void main(String[] args) {
        Kangaroo k = new Kangaroo();
        k.getMarsupialDescription();
        k.getKangarooDescription();
    }
}