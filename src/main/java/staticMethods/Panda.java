package staticMethods;

public class Panda extends Bear {
    public static String eat() {
        return "Panda bear is chewing";
    }

    public void makeSound() {
        System.out.println("Nom Nom Nom... " + eat());
    }

    public static void growl() {
        System.out.println("GRRRRRRrrrrrr");
    }

    public static void main(String[] args) {
        Bear p = new Bear();
        p.makeSound();
    }
}
