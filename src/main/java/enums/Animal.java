package enums;

public enum Animal {
    REPTILE(true),
    DOG(false);

    private boolean coldBlooded;
    Animal(boolean coldBlooded) {
        this.coldBlooded = coldBlooded;
    }


}
