package inheritance.human.mammal;

public class Elephant extends Mammal {
    public String trunk;
    public Elephant(int age) {
        super(age);
        super.trunk = "Asd";
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        new Elephant(2).sayHello();
    }
}
