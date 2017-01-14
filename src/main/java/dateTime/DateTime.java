package dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTime {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, 9, 24);
        DateTimeFormatter longFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter medFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter customPattern = DateTimeFormatter.ofPattern("MMM dd yyyy");

        LocalDate parsedDate = LocalDate.parse("May 07 1984", customPattern);
        System.out.println("parsedDate = " + parsedDate);

        LocalDate anotherDate = LocalDate.ofYearDay(2015, 2);
    }
}
