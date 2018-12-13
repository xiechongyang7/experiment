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
        Man man = new Man();

//        System.out.println(isEmpty(man));
//        System.out.println(man.toString());
//
        System.out.println(StringUtils.isEmpty(man.isChuSheng()));
        System.out.println(man.isChuSheng());

    }
}
