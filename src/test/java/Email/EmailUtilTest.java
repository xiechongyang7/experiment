package Email;


import org.junit.jupiter.api.Test;


class EmailUtilTest {

    @Test
    public void email(){

        EmailInfo emailInfo = EmailInfo
                .custom()
                .setAddressee("791465939@qq.com")
                .setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件")
                .build();

        System.out.println(emailInfo.toString());
        try {
//            for(int i= 0;i<10;i++){
            EmailUtil.sendEmail(emailInfo);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}