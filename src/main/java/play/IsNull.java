package play;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/6 16:54
 * @Author xie
 */
public class IsNull {


    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static void main(String arg[]){
//        Man man = new Man();
//
////        System.out.println(isEmpty(man));
////        System.out.println(man.toString());
////
//        System.out.println(StringUtils.isEmpty(man.isChuSheng()));
//        System.out.println(man.isChuSheng()); 4 5 6    7 8 9    10 11 12    1 2 3    4 5 6    7 8 9
        try {
            isContains("200206,200201","200211","错了");
            System.out.println("包含");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void isContains(String str1,String str2, String msg) throws Exception {
        if(!str1.contains(str2)){
            throw new Exception(msg);
        }
    }
}
