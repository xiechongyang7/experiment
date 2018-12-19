package unitTest;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/14 11:46
 * @Author xie
 */
public class Assert {

    /**
     * 不为空判断
     * @param str 判断的参数
     * @return 为空返回true
     */
    public static boolean isNull(String str){
        return str==null||"".equals(str)||0>=str.length()||"null".equals(str);
    }

    public static void main(String arg[]){
        String a  = null+"";
        System.out.println(isNull(a));
    }



}
