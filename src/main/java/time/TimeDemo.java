package time;

import java.time.Duration;
import java.time.Period;

public class TimeDemo {

    protected static Period salary = Period.of(1, 0, 0);
    protected static Period taxRepayments = Period.of(0, 3, 0);
    protected static Period healthInsuranceDue = Period.of(0, 0, 30);
    protected static Duration tripViewRefresh = Duration.ofMinutes(1);
    protected static Duration alternateTripViewRefresh = Duration.ofSeconds(60);
    protected static Duration lookAtMyWatch = Duration.ofSeconds(361);

    public static void main(String[] args) {
        /** Period are printed in format  P xY | xM | xD **/
        System.out.println("salary is a period of " + salary);
        System.out.println("tax repayments are in a period of " + taxRepayments);
        System.out.println("health repayments paid in a period of " + healthInsuranceDue);

        /** Longest unit in a duration is 'day'
         * Also allows
         * - hours
         * - minutes
         * - seconds
         * - milliseconds
         * - nanoseconds
         *
        /** Duration is printed in format using largest unit of time available **/
        System.out.println("tripViewRefresh = " + tripViewRefresh);
        System.out.println("alternateTripViewRefresh = " + alternateTripViewRefresh);
        System.out.println("lookAtMyWatch = " + lookAtMyWatch);
    }
}
