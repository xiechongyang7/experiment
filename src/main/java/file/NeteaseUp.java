package file;

import com.netease.cloud.ClientConfiguration;
import com.netease.cloud.ClientException;
import com.netease.cloud.ServiceException;
import com.netease.cloud.auth.BasicCredentials;
import com.netease.cloud.auth.Credentials;
import com.netease.cloud.services.nos.NosClient;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/30 18:15
 * @Author xie
 */
public class NeteaseUp {


    public static void init() {
        try {
            String endPoint =  "nos-eastchina1.126.net";
            String accessKey = "your-accesskey";
            String secretKey = "your-secretKey ";
            Credentials credentials = new BasicCredentials(accessKey, secretKey);
            NosClient nosClient = new NosClient(credentials);
            nosClient.setEndpoint(endPoint);
        } catch (ServiceException e1) {
            System.out.println("Error Message:    " + e1.getMessage());    //错误描述信息
            System.out.println("HTTP Status Code: " + e1.getStatusCode()); //错误http状态码
            System.out.println("NOS Error Code:   " + e1.getErrorCode());  //NOS 服务器定义错误码
            System.out.println("Error Type:       " + e1.getErrorType());  //NOS 服务器定义错误类型
            System.out.println("Request ID:       " + e1.getRequestId());  //请求 ID,非常重要，有利于对象存储开发人员跟踪异常请求的错误原因
        } catch (ClientException e2) {
            System.out.println("Error Message: " + e2.getMessage());       //客户端错误信息
        }
    }
}
