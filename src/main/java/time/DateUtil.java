package time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/30 11:21
 * @Author xie
 */
public class DateUtil {

    /** 完整时间字符串格式码 */
    public static final String FULL_TIME = "yyyy-MM-dd HH:mm:ss";
    /** 标准日期字符串格式码 */
    public static final String DATE = "yyyy-MM-dd";
    /** 标准时间字符串格式码 */
    public static final String TIME = "HH:mm:ss";
    /** 简化版全时间字符串格式码 */
    public static final String SIMPLE_FULLTIME = "yyyyMMddHHmmss";
    /** 简化版日期字符串格式码 */
    public static final String SIMPLE_DATE = "yyyyMMdd";
    /** 简化版时间字符串格式码 */
    public static final String SIMPLE_TIME = "HHmmss";
    /** 简化版毫秒时间字符串格式码 */
    public static final String SIMPLE_FULLTIME2 = "yyyyMMddHHmmss";

    /**
     * 转换日志对象为标准全时间描述文本
     *
     * @param time 时间对象
     * @return 描述文本
     */
    public static String toFullTimeStr(Date time) {
        return new SimpleDateFormat(SIMPLE_FULLTIME2).format(time);
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

    /**
     * 请求流水号规则 13位时间戳加7位随机数
     * @return 20位数字流水号 例如：15356212279479557
     */
    public static String getIdByTime() {
        Random random = new Random();
        String randomStr = "";
        for (int i = 0; i < 7; i++) {
            randomStr += random.nextInt(10);
        }
        return getNowTimeStamp() + randomStr;
    }


    public static void  main(String arg[]){
//        for(int i = 0; i < 7; i++){
//            System.out.println(  getIdByTime());
//        }
        for(int i = 0; i < 7; i++){
            System.out.println( toFullTimeStr(new Date()));
        }

    }
}
