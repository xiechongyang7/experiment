
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/14 10:57
 * @Author xie
 */
public class tex {
    public static void main(String[] arg) throws Exception {
        System.out.println("*********************start");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件位置：");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        List<String> strList = null;

        try {
            strList = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("文件读取出错：");
        }

        if (strList.isEmpty()) {
            throw new Exception("没有读取到有效信息");
        }

        String className = "className";
        List<String> setList = new ArrayList<String>();
        List<String> getList = new ArrayList<String>();
        for (int i = 0; i < strList.size(); i++) {
            String line = strList.get(i);
            if (!isNullStr(line)) {

                if(line.contains("package")||line.contains("import")||line.contains("static")){
                    continue;
                }

                if (line.contains("public")) {
                    if (line.contains("class")) {
                        className = line.split(" ")[2];
                        className = className.substring(0,1).toLowerCase()+className.substring(1);
                        continue;
                    } else {
                        break;
                    }
                }

                int bankLast  = line.lastIndexOf(" ");
                int lastStr = line.indexOf(";");
                String value = "";
                try{
                    value = line.substring(bankLast+1,lastStr);
                }catch (Exception e){
                    System.out.println(value+"出错了");
                    continue;
                }

                if(line.contains("boolean")||line.contains("Boolean")){
                    String fieldName = value.substring(0,1).toUpperCase()+value.substring(1);
                    String getMethodName = className+".is"+ fieldName +"();";
                    getList.add(getMethodName);
                    StringBuilder setMethodName = new StringBuilder(className);
                    setMethodName.append(".set");
                    setMethodName.append(fieldName);
                    setMethodName.append("(");
                    setMethodName.append(value);
                    setMethodName.append(");");
                    setList.add(String.valueOf(setMethodName));
                    continue;
                }


                String fieldName = value.substring(0,1).toUpperCase()+value.substring(1);
                String getMethodName = className+".get"+ fieldName +"();";
                getList.add(getMethodName);
                StringBuilder setMethodName = new StringBuilder(className);
                setMethodName.append(".set");
                setMethodName.append(fieldName);
                setMethodName.append("(");
                setMethodName.append(value);
                setMethodName.append(");");
                setList.add(String.valueOf(setMethodName));
            }
        }

        System.out.println("---------------------------set");
        for(String str:setList){
            System.out.println(str);
        }
        System.out.println("---------------------------get");
        for(String str:getList){
            System.out.println(str);
        }
        System.out.println("*********************end");
    }


    /**
     * 判断是否为空
     *
     * @param str
     * @return 空 true
     */
    private static boolean isNullStr(String str) {
        return str.length() == 0 || "".equals(str) || str == null;
    }

}

