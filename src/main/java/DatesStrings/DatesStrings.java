package DatesStrings;

import java.time.ZoneId;

public class DatesStrings {
    public DatesStrings(){
        method1();
    }

    void method1(){
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("Norway") || z.contains("Oslo"))
                .sorted().forEach(System.out::println);
    }
}
