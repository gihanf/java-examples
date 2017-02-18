package generics;

public class SizeLimitedCrate<T, U> {
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit) {
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }

    public static void main(String[] args) {
        Elephant e = new Elephant();
        Integer numPounds = 15_000;
        SizeLimitedCrate<Elephant, Integer> c1 = new SizeLimitedCrate<>(e, numPounds);
    }

    /** Specifying a generic type allows the compiler to enforce proper use of the generic type.
     * Behind the scenes, the compiler replaces all references to T in Crate with Object.
     *
     * Basically: After the code compiles, your generics are actually just Object types.
     * This process of removing the generics syntax from your code is known as type erasure.
     *  **/

}

class Elephant {}