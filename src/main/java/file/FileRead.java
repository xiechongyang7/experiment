package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/7 11:44
 * @Author xie
 */
public class FileRead {

    public static void main(String[] arg) throws IOException {

        File file = new File("G:\\hha.txt");

        List<String> list = FileUtils.readLines(file, "UTF-8");
        List<String> newList = new ArrayList<>();
        for (String line : list) {
            String str[] = line.split("\"");
            StringBuilder builder = new StringBuilder("UPDATE PGTECO  SET EX_ACCT_NO = \t'");
            builder.append(str[3])
                    .append("'\t  where CONTRACT_NO = \t'")
                    .append(str[1])
                    .append("';");
            newList.add(builder.toString());
        }

        FileUtils.writeLines(new File("G:\\hha1.txt"),newList);

    }
}
