package promotion;

public class PromotionExample {

//    public void print(byte x) {
//        System.out.print("byte");
//    }
    public void print(byte x) {
        System.out.print("byte");
    }
//    public void print(Double x){
//        System.out.println("Double");
//    }
    public void print(float x) {
        System.out.print("float");
    }
//    public void print(Object x) {
//        System.out.print("Object");
//    }
    public void print(Double d) {
        System.out.println("Double");
    }

    public static void main(String[] args) {
        PromotionExample promotionExample = new PromotionExample();
        int b = 2;
//        Integer s = new Integer(2);
        promotionExample.print(b);
    }

}
