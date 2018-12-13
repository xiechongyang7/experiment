package time;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {

    @Test
    void toFullTimeStr() {
//        System.out.println(DateUtil.toFullTimeStr(new Date()));
        System.out.println(getNowTimeStamp());

    }

    /**
     * 取得当前时间戳（精确到秒）
     * @return nowTimeStamp 例如：1530587206000
     */
    public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time);
        return nowTimeStamp;
    }

}
