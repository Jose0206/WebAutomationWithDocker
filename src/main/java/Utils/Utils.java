package Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
    private LocalDateTime now = LocalDateTime.now();
    private String hoy = now.format(dtf);


    public String getTodaysDate() {
        return hoy;
    }

    public String getThreeMonthsDate() {
        return LocalDateTime.from(now).plusMonths(3).format(dtf);
    }

    public String getTomorrowsDate() {
        return LocalDateTime.from(now).plusDays(1).format(dtf);
    }
}
