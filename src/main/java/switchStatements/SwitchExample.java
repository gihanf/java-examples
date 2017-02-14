package switchStatements;

public class SwitchExample {

    public static void main(String[] args) {

        int a = 4;
        switch(a) {
            case 5:
                break;
            default:
                break;
        }

        char c = 'a';
        switch(c) {
            case '3':
                break;
        }

        byte b = 0b101;
        switch (b) {
            case 0b100:
                System.out.println("I'm a happy byte");
                break;
            case 0b101:
                System.out.println("I'm the real byte");
                break;
        }

        short s = 13;
        switch(s) {
            case 2:
                System.out.println("I forgot to use a break statement");
            case 13:
                System.out.println("Lucky 13 was short");
        }

        String hairColour = "blond";
        switch(hairColour) {
            case "brunette":
                System.out.println("brown hair");
                break;
            case "blond":
                System.out.println("golden yellow hair");
                break;
            case "black":
                System.out.println("black hair");
                break;
        }
    }
}
