package play;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/12/6 16:55
 * @Author xie
 */
public class Man {
    private String name;
    private String sex;

    private Boolean isChuSheng;

    public Boolean isChuSheng() {
        return isChuSheng;
    }

    public void setChuSheng(Boolean chuSheng) {
        isChuSheng = chuSheng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Man{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
