package com.sang.demo.controller;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sang.demo.scheduler.jobs.LoggingAfter10SecondsJob;

@RestController
@RequestMapping("/api")
public class GreetingController {

  @Autowired
  Environment env;

  @Value("${spring.devtools.restart.enabled:false}")
  private String devtoolsRestartEnabled;

  @Value("${spring.profiles.active:false}")
  private String active;
  // hello world
  @GetMapping("/hello")
  public String hello() {
    System.out.println("devtoolsRestartEnabled : "+devtoolsRestartEnabled);
    return "Hello world!!!!";
  }

  // bye world
  @GetMapping("/bye")
  public String bye() {
    System.out.println("Enviroment spring.profiles.active : "+active);

    String senv = System.getProperty("spring.profiles.active");
    System.out.println("System spring.profiles.active : "+senv);
    return "Bye world22";
  }

  @GetMapping("/scheduled")
  public void getReadyScheduleList() throws SchedulerException{
    //get all the scheduled jobs
    System.out.println("getReadyScheduleList");
    StdSchedulerFactory.getDefaultScheduler().getTriggerKeys(null).forEach(System.out::println);
  }
  
  @GetMapping("/10s")
  public String postLoggingAfter10seconds() throws SchedulerException {
    // Job을 실행하기 이전에 언제 실행할지 Trigger를 설정하는 부분
      // JobDetail 생성
      JobDetail job = JobBuilder.newJob(LoggingAfter10SecondsJob.class)
              .withIdentity("oneTimeJob")
              .build();

      // 현재 시간으로부터 N시간 후를 계산
      Date startTime = new Date(System.currentTimeMillis() + 10 * 1000);

      // SimpleTrigger 생성
      SimpleTrigger trigger = TriggerBuilder.newTrigger()
              .withIdentity("simpleTrigger")
              .startAt(startTime)
              .withSchedule(SimpleScheduleBuilder.simpleSchedule())
              .build();

      // 스케줄러에 Job과 Trigger 등록
      StdSchedulerFactory.getDefaultScheduler().scheduleJob(job, trigger);
      StdSchedulerFactory.getDefaultScheduler().start();

      return "LoggingAfter10seconds";      
  }
}