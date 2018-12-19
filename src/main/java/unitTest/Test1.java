package unitTest;

import java.util.Random;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 14:43
 * @Author xie
 */
public class Test1 {

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
    /**
     * 取得当前时间戳（精确到秒）
     * @return nowTimeStamp 例如：1530587206000
     */
    public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }


    public static void  main(String arg[]){
        for(int i = 0; i < 7; i++){
            System.out.println(  getNowTimeStamp());
        }

    }
}
