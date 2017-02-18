package generics;

public class Crate<T> {
    private T contents;
    public T emtpyCrate() {
        return contents;
    }

    public void packCrate(T contents) {
        this.contents = contents;
    }

    /** Example of generic static method
     * The first <T> is the formal parameter type. It must be specified or else the code will not compile
     * **/
    public static <T> Crate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Crate<T>();
    }

}
