package varargs;

import java.util.ArrayList;
import java.util.List;

public class VarArgs {

    public void sayHello(String ...statements) {
        for (String statement : statements) {
            System.out.print(statement + " ");
        }
    }

    public static void main(String args[]) {
        VarArgs varArgs = new VarArgs();
        varArgs.sayHello("Hello", "Gihan");

        int x = 0;
        while(x++ < 10) {}
        String message = x > 10 ? "Greater than" : "false";
        System.out.println(message+","+x);
        StringBuilder sb = new StringBuilder("bob");
        StringBuilder sb2 = new StringBuilder("bob");
        System.out.println(sb == sb2);
        System.out.println(String.valueOf(sb));

        int []intArray = new int[1];
        intArray[0] = 2;
        System.out.println("intArray = " + intArray[0]);

        int[][] multi = new int[1][];

        ArrayList myArrayList = new ArrayList();
        myArrayList.add(2L);
        myArrayList.add("tiger");

        for (Object o : myArrayList) {
            System.out.println("o = " + o);
        }

        System.out.println("ArrayList Equality Checking");
        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        System.out.println(one.equals(two));
        one.add("a");
        System.out.println(one.equals(two));
        two.add(new String("a"));
        System.out.println(one.equals(two));

        String number = "2";
        int a = Integer.valueOf(number);
        Integer b = Integer.parseInt(number);


    }
}
