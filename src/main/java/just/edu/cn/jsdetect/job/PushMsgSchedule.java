package just.edu.cn.jsdetect.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: chenpeng
 * @Datetime: 2020/5/25 15:16
 * @Version: V1.0
 */
public class PushMsgSchedule {

    public static void main(String[] args) throws SchedulerException {
        String account = args[0]; // 获取参数
        String pwd = args[1]; // 获取密码

        System.out.println("获取到的参数" + account + "," + pwd);

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(PushMsgJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("account", account)
                .usingJobData("pwd", pwd)
                .build();


        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("0 30 8 * * ? *"))
                .build(); // 每天早上8点半执行

        scheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println("scheduler start1...");
        scheduler.start();

    }
}
