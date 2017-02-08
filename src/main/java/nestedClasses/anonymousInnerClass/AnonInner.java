package nestedClasses.anonymousInnerClass;

/** Anonymous inner classes is a local inner class that does not have a name.
 * They can even be defined as an argument to another method. **/
public class AnonInner {
    abstract class SaleOnToday {
        abstract int dollarsOff();
    }

    public int admission(int basePrice) {
        SaleOnToday saleOnToday = new SaleOnToday() {
            @Override
            int dollarsOff() {
                return 3;
            }
        };

        return basePrice - saleOnToday.dollarsOff();
    }
}
