package localisation;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class LocalisationDemo {
    public static void main(String[] args) {

        /**
         * Locale must be created with either:
         * - a lowercase language e.g. "en"
         * - a lowercase language and an uppercase country code e.g. "en" "US"
        */

        /** Ways to create a Locale **/

        // Locale with language and country code
        Locale myLocale = new Locale("en", "AU");
        System.out.println("myLocale = " + myLocale);       // "en_AU"

        // Locale with builder
        Locale l2 = new Locale.Builder()
                .setRegion("IN")
                .setLanguage("hi")
                .build();

        // Locale with language only
        myLocale = new Locale("en");
        myLocale = Locale.ENGLISH;

        ResourceBundle bundle = ResourceBundle.getBundle("Zoo", myLocale);
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("open"));

        Properties props = new Properties();
        props.getProperty("java");
    }
}
