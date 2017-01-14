package staticMethods;

public class Bear {
    public static String eat() {
        return "Bear is eating";
    }

    public void makeSound() {
        System.out.println("Nom Nom Nom... " + eat());
    }
}
