package Schedulers;

import org.quartz.*;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * Created by RamiroIvan on 02/10/16.
 */
//@WebListener
//public class QuartzListener extends QuartzInitializerListener {
//    private static final Logger LOG = LoggerFactory.getLogger(QuartzListener.class);
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        super.contextInitialized(sce);
//        ServletContext ctx = sce.getServletContext();
//        StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);
//        try {
//            Scheduler scheduler = factory.getScheduler();
//            JobDetail job = JobBuilder.newJob(SchedulerJob.class).build();
//            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simple").withSchedule(
//                    CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
//            ).startNow().build();
//            scheduler.scheduleJob(job, trigger);
//            scheduler.start();
//        } catch (Exception e) {
//            LOG.error("Ocurri\u00f3 un error al calendarizar el trabajo", e);
//        }
//    }
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        super.contextDestroyed(sce);
//    }
//}
