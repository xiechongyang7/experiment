package getImg;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/2 17:30
 * @Author xie
 */
public class GetImg {


    public static void main(String arg[]){
        long a  = System.currentTimeMillis();
        try {
            String a1 = null;
            for (int i = 2;i<5000;i++){
                try {
                    a1 = HttpConnectionPoolUtil.get("http://www.duokan.com/book/"+i);
                    Document doc = Jsoup.parse(a1);
                    System.out.println(doc.title());
                }catch (Exception e){
                    System.out.println(i+"出错了"+":::::::::::::::::::::::");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        long b  = System.currentTimeMillis();
            System.out.println(b-a);
//        Document doc = null;
//        try {
//            long a  = System.currentTimeMillis();
//            for(int i = 2;i<5000;i++){
//                try {
//                    doc = Jsoup.connect("http://www.duokan.com/book/"+i).get();
//                    String title = doc.title();
//                    System.out.println(title);
//                }catch (Exception e){
//                    System.out.println(i+"出错了"+":::::::::::::::::::::::");
//                }
//
//            }
//            long b  = System.currentTimeMillis();
//            System.out.println(b-a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String title = doc.title();
    }

}
