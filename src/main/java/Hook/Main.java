package Hook;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/3 18:17
 * @Author xie
 */
public class Main {

    public static void main(String arg[]){
        UserNumServiceImpl userNumService = new UserNumServiceImpl();
        userNumService.user(new HowNum() {
            @Override
            public String getNum() {
                return "哈哈";
            }
        });
    }
}
