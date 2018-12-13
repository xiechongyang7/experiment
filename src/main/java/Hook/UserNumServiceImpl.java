package Hook;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/3 18:16
 * @Author xie
 */
public class UserNumServiceImpl implements UserNumService {

    @Override
    public void user(HowNum howNum) {
        System.out.println(howNum.getNum());
    }
}
