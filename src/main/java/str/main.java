package str;

import java.io.IOException;

/**
 * @description:
 * @author: xiechongyang
 * @create: 2021-04-08 15:51
 **/
public class main {


    public static void main(String[] args) {
        getReplenish();
    }


    public static void getCard(){
        String phone = "15244446666";
        String card = "65548472159842";
//        String string = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
//        String str = card.replaceAll("(\\d{4})(\\d{11})(\\d{4})", "$1****$3");
//        System.out.println(string);
//        System.out.println(str);

        System.out.println(card.substring(0,4)+"******"+card.substring(card.length()-4));
    }


    private static void getReplenish(){
        System.out.println(String.format("%04d", 99));
        System.out.println(String.format("%04d", 9));
        System.out.println(String.format("%04d", 99));
        System.out.println(String.format("%04d", 999));
//        if(str == null||"".equals(str)){
//            return
//        }
//        if(str.length()<){
//            ("%04d", 99)
//        }
    }

    public static void split() throws IOException {


        String str[]  = "\"WT20180912000006195\"\t\"6214837906704006\"\n".split("\"");


        System.out.println(str[1]+"----"+str[3]);
    }

}
