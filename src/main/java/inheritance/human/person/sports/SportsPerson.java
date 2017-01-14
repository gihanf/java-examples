package inheritance.human.person.sports;

import inheritance.human.person.Person;

public class SportsPerson extends Person {

    public String skill;

    public static int a = 1;
    public static final int b = 2 + a;
    public static int c = a + 1;
    public static int d;
    public int e = 3;
//    public final static int d;

    {
        a = 3;
//        b = 1;
        d = 34;
    }

    static {
        c = 5;
//        d = 5;
    }

    public SportsPerson(String skill, String name, String gender) {
        super(gender, name);
        this.skill = skill;
    }

    public static void main(String[] args) {
        SportsPerson sportsPerson = new SportsPerson("soccer", "Pele", "male");
        System.out.println("sportsPerson.gender = " + sportsPerson.gender);
        System.out.println("sportsPerson.name = " + sportsPerson.name);
        System.out.println("sportsPerson.skill = " + sportsPerson.skill);

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
