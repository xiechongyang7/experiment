package batchdome;

import org.springframework.batch.item.ItemProcessor;

/**
 * @Description
 * @Since JDK1.8
 * @Createtime 2018/11/8 14:18
 * @Author xie
 */
public class FilterReportProcessor implements ItemProcessor<Report, Report> {

    @Override
    public Report process(Report item) throws Exception {

        //filter object which age = 30
        if(item.getAge()==30){
            return null; // null = ignore this object
        }
        return item;
    }

}