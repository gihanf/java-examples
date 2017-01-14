package abstractDemo;

public abstract class Bird {
    int donkey;

    protected void fly() {
        System.out.println("Bird is flying");
    }

    public static void main(String[] args) {
        Bird bird = new Pelican();
        bird.fly();

        int a[] = {1, 2, 053, 4};
        int b[][] = {{1, 2, 4}, {2, 2, 1}, {0, 43, 2}};
        System.out.println(b[2][1]);
        System.out.println(a[2]);
        System.out.println(a[3] == b[0][2]);

        System.out.println(" " + (a[2] == b[2][1]));
        System.out.println(bird.donkey);

    }
}

class Pelican extends Bird {
    protected void fly() {
        System.out.println("Pelican is flying");
    }
}
