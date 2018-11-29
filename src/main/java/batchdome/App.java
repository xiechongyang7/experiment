//package batchdome;
//
//
//
///**
// * @Description
// * @Since JDK1.8
// * @Createtime 2018/11/8 14:19
// * @Author xie
// */
//public class App {
//
//    public static void main(String[] args) {
//
//        String[] springConfig  =
//                {
//                        "/context.xml",
//                        "/job.xml"
//                };
//
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext(springConfig);
//
//        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
//        Job job = (Job) context.getBean("reportJob");
//
//        try {
//
//            JobExecution execution = jobLauncher.run(job, new JobParameters());
//            System.out.println("Exit Status : " + execution.getStatus());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Done");
//
//    }
//}
