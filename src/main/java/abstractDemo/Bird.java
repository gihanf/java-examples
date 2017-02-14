package abstractDemo;

public abstract class Bird {
    int feet;

    protected void fly() {
        System.out.println("BirdDemo is flying");
    }

    public static void main(String[] args) {
        Bird bird = new Pelican();
        bird.fly();
        System.out.println(bird.feet);
    }
}

class Pelican extends Bird {
    protected void fly() {
        System.out.println("Pelican is flying");
    }
}
