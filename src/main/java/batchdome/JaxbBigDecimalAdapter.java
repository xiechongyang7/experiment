package batchdome;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/8 14:14
 * @Author xie
 */
public class JaxbBigDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    @Override
    public String marshal(BigDecimal obj) throws Exception {
        return obj.toString();
    }

    @Override
    public BigDecimal unmarshal(String obj) throws Exception {
        return new BigDecimal(obj.replaceAll(",", ""));
    }

}