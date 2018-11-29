package unitTest;

import java.util.UUID;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/5 15:23
 * @Author xie
 */
public class UnitTest {

    /**
     *
     * 一
     *  1> idea 快捷键 ctrl+shift+t
     *  2> eclipse 然后右击java类文件 new----->JUnit Test Case
     * 二
     *  断言
     * 三
     *  注释
     * 四
     *  覆盖度
     * 五
     *  maven
     * 六
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    /**
     * @param a
     * @return 真假
     */
    public boolean isTrue(int a){
        if(a>0){
            return false;
        }else if (a<0){
            return false;
        }else {
            return false;
        }
    }

    /**
     * @param a
     * @return 字符串
     */
    public String isNull(int a){
        if(a>0){
            return "......>......";
        }else if (a<0){
            return "......<......";
        }else {
            return null;
        }
    }

}
