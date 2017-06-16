package collections.maps;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Map<String, Integer> grandSlamTitles = new HashMap<>();
        grandSlamTitles.put("Aus Open", 5);
        grandSlamTitles.put("Wimbledon", 3);
        grandSlamTitles.put("US Open", 7);
        grandSlamTitles.put(null, 2);
        grandSlamTitles.put("French Open", null);

        System.out.println("Before");
        System.out.println("grandSlamTitles = " + grandSlamTitles);
        grandSlamTitles.merge("Aus Open", 4, (a, b) -> a + b);
        grandSlamTitles.merge("Unknown Open", 1, (a, b) -> a + b);
        grandSlamTitles.merge(null, 1, (a, b) -> a + b);

        System.out.println("After");
        System.out.println("grandSlamTitles = " + grandSlamTitles);
    }
    
}
