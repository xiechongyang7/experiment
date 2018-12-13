package file;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 11:49
 * @Author xie
 */
public class hah {

    public static void main(String[] arg) throws IOException {


            String str[]  = "\"WT20180912000006195\"\t\"6214837906704006\"\n".split("\"");


            System.out.println(str[1]+"----"+str[3]);
    }
}
