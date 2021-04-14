package shell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description
 * @author: xcy
 * @createTime: 2020/6/18 15:09
 */
public class ShellDome {


    public static void main(String[] args) {
        run("sh test.sh");
    }
    /**
     * 执行shell脚本
     *
     * @param cmd
     */
    private static void run(String cmd) {

        System.out.printf("开始执行脚本:" + cmd);
        Process process = null;
        BufferedReader br = null;

        try {
            process = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String str = null;

            while ((str = br.readLine()) != null) {
                System.out.printf("脚本执行" + str);
                if ((str != null) && (!str.equals(""))) {
                    if (str.indexOf("SOME_ERR_KEYWORD") > 0) {// TODO
                        // 脚本打印某些错误关键字
                        System.out.printf("脚本执行错误:" + str);
//                        SmsUtils.reqSms("数据清理脚本执行错误:" + str);
                        return;
                    }
                }
            }
            br.close();
            process.waitFor();

            System.out.printf("脚本:" + cmd + "执行正常结束");

        } catch (Exception e) {
            System.out.printf("脚本执行错误", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
            if (process != null) {
                process.destroy();
            }
        }
    }
}
