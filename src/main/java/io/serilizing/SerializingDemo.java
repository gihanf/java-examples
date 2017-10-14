package io.serilizing;

import java.io.*;

public class SerializingDemo {

    public static class Bird implements Serializable {
        protected String name = "Bridget";

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Bird() {
            this.name = "Matt";
        }
    }

    public static class Eagle extends Bird implements Serializable {
        {
            this.name = "Janette";
        }

        public Eagle() {
            //this.name = "Daniel";
        }
    }

    public static void main(String[] args) throws IOException {
        SerializingDemo demo = new SerializingDemo();
        Eagle e1 = new Eagle();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./test"));
        out.writeObject(e1);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("./test"));
        try {
            Object o = in.readObject();
            if (o instanceof Eagle) {
                Eagle eagle = (Eagle) o;
                System.out.println(eagle);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
