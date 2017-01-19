import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Integer integer = 1;

        if (1 == integer) {
            System.out.println("can compare");
        }

        String s1 = "Hello";
        String s2 = "Hello";

        if ("Hello" == s2) {
            System.out.println("good");
        }

        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.ofDays(1).ofYears(2);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle
                .SHORT);
        System.out.println(f.format(d));

    }
}
