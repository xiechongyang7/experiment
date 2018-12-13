package time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/30 11:48
 * @Author xie
 */
public class TimeDemo {

    public static void main(String arg[]) {
        System.out.println("getLocalDate::\t" + getLocalDate());
        System.out.println("LocalDateTime::\t" + LocalDateTime());
        System.out.println("Instant::\t" + Instant());
        for(int i = 0; i < 7; i++){
            System.out.println("LocalTime::\t" + LocalTime());
        }
    }

    /**
     * eg. 2018-11-30
     *
     * @return
     */
    public static String getLocalDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    /**
     * eg. 2018-11-30
     *
     * @return
     */
    public static String Instant() {
        Instant now = Instant.now();
        return now.toString();
    }

    public static String LocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.toString();
    }

    public static String LocalTime() {
        LocalTime now = LocalTime.now();
        return now.toString();
    }
}
