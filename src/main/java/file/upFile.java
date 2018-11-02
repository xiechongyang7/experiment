package file;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.utils.Jackson;

import java.io.File;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/2 16:17
 * @Author xie
 */
public class upFile {


    public static void main(String arg[]){
        COSCredentials cred = new BasicCOSCredentials("AKID20nbFjEALRM6fui3EJG2N6mIclmesfx5", "A9w46xgEoHZhfS4oW3PabR6f4JNMBoGd");
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
        COSClient cosClient = new COSClient(cred, clientConfig);
        String bucketName = "seesea-1-1252218384";

        // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
        // 大文件上传请参照 API 文档高级 API 上传
        File localFile = new File("D:\\1.jpg");
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        //                                                https://seesea-1-1252218384.cos.ap-shanghai.myqcloud.com/1.jpg
        String key = "upload_single_demo.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
//        JSONPObject jsonpObject = new JSONPObject("putObjectResult",putObjectResult);
//        new JSONPObject()
        System.out.println(Jackson.toJsonString(putObjectResult));
    }



}
