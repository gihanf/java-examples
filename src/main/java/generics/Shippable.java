package generics;

// There are three ways a class can approach implementing this interface

/**
 * 1. Specify the generic type in the class (see ShippableElephantCrate)
 * 2. Create a generic class (see ShippableAbstractCrate)
 * 3. Don't use generics at all (see ShippableCrate)
 *
 * Oracle refers to types whose information is fully available at runtime as "reifiable"
 * Reifiable types can do anything that Java allows.
 *
 */
public interface Shippable<T> {
    void ship(T t);
}
