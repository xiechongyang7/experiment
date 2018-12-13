package Email;


import org.apache.http.client.config.RequestConfig;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/29 11:03
 * @Author xie
 */
public class EmailInfo {

    //收件人
    private final String addressee;
    //发送人
    private final String sender;
    //内容
    private final String content;
    //标题
    private final String subject;
    //图片
    private List<String> image;

    public String getAddressee() {
        Assert.notNull(addressee, "addressee can't not");
        return addressee;
    }

    public String getSender() {
        Assert.notNull(sender, "sender can't not");
        return sender;
    }

    public String getContent() {
        Assert.notNull(content, "content can't not");
        return content;
    }

    public String getSubject() {
        Assert.notNull(subject, "subject can't not");
        return subject;
    }

    public List<String> getImage() {
        return image;
    }

    public EmailInfo(String addressee, String sender, String content, String subject, List<String> image) {
        this.addressee = addressee;
        this.sender = sender;
        this.content = content;
        this.subject = subject;
        this.image = image;
    }

    public static EmailInfo.builder custom() {
        return new EmailInfo.builder();
    }

    public static class builder {
        //收件人
        private String addressee = "xiechongyang7@163.com";
        //发送人
        private String sender="xiechongyang7@163.com";
        //内容
        private String content = "你好";
        //标题
        private String subject = "标题";
        //图片
        private List<String> image;

        public EmailInfo.builder setAddressee(String addressee) {
            this.addressee = addressee;
            return this;
        }

        public EmailInfo.builder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public EmailInfo.builder setContent(String content) {
            this.content = content;
            return this;
        }

        public EmailInfo.builder setSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public EmailInfo.builder setImage(List<String> image) {
            this.image = image;
            return this;
        }

        public EmailInfo build() {
            return new EmailInfo(this.addressee,
                    this.sender,
                    this.content,
                    this.subject,
                    this.image);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EmailInfo{");
        sb.append("addressee='").append(addressee).append('\'');
        sb.append(", sender='").append(sender).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", subject='").append(subject).append('\'');
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }
}
