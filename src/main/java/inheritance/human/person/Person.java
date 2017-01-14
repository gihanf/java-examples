package inheritance.human.person;

import inheritance.human.Human;

public class Person extends Human {

    public String name;

    public Person(String gender, String name) {
        super(gender);
        this.name = name;
    }
}
