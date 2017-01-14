package lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwim;
    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        species = speciesName;
        canHop = hopper;
        canSwim = swimmer;
    }
    public boolean canHop() { return canHop; }
    public boolean canSwim() { return canSwim; }
    public String toString() { return species; }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        List<Animal> hoppers = new ArrayList<>();

//        animals.stream()
//                .filter(Animal::canHop)
//                .map(animal -> {
//                    System.out.println(animal.species);
//                    hoppers.add(animal);
//                });
//                .collect(Collectors.toList());

//        animals.forEach(animal -> {
//            if (animal.canHop()) {
//                System.out.println(animal.species);
//            }
////            return;
//        });

        animals.stream()
                .filter((Animal a) -> a.canHop())
                .forEach((Animal a) -> {
                    System.out.println(a.species);
                    System.out.println("Asdas");
                    a.canSwim();
                });

//        for (Animal hopper : hoppers) {
//            System.out.println("hopper = " + hopper.species);
//        }
// pass class that does check
    }
}