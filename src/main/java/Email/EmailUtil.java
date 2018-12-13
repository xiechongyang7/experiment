package Email;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/29 11:05
 * @Author xie
 */
public class EmailUtil {


    private final static String MAIL_HOST = "smtp.163.com";
    private final static String MAIL_TRANSPORT_PROTOCOL = "smtp";
    private final static String MAIL_SMTP_AUTH = "false";

    private final static String HOST = "smtp.163.com";
    private final static String USER= "xiechongyang7@163.com";
    private final static String PWD= "qwe123";

    private  static Session session = null;
    private  static Transport transport = null;

    static {
        try {
            InitTransport();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static void InitTransport() throws MessagingException {
        Properties prop = new Properties();
        prop.setProperty("mail.host", MAIL_HOST);
        prop.setProperty("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);
        prop.setProperty("mail.smtp.auth", MAIL_SMTP_AUTH);
        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        session = Session.getInstance(prop);
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        //2、通过session得到transport对象
        transport = session.getTransport();
        //3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        transport.connect(HOST, USER, PWD);
    }

    private static void closedTransport(Transport ts){
        try {
            ts.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static MimeMessage createMail(EmailInfo emailInfo) throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress(emailInfo.getSender()));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailInfo.getAddressee()));
        //邮件的标题
        message.setSubject(emailInfo.getSubject());
        //邮件的文本内容

        MimeMultipart mm = new MimeMultipart();
        MimeBodyPart text = new MimeBodyPart();
        text.setContent(emailInfo.getContent(), "text/html;charset=UTF-8");
        mm.addBodyPart(text);

        if(null != emailInfo.getImage() && emailInfo.getImage().isEmpty()){
            MimeBodyPart image = new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource("src\\1.jpg"));
            image.setDataHandler(dh);
            image.setContentID("xxx.jpg");
            mm.addBodyPart(image);
            mm.setSubType("related");
        }

        message.setContent(mm, "text/html;charset=UTF-8");

        //返回创建好的邮件对象
        return message;
    }

    public static void sendEmail(EmailInfo emailInfo){
        try {
            MimeMessage mimeMessage =  createMail(emailInfo);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
