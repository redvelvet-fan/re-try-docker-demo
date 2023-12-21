package com.sang.demo.scheduler.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class LoggingAfter10SecondsJob implements Job {

  @Override
  public void execute(JobExecutionContext context) throws JobExecutionException {
    // Trigger 가 실행되면 어떤 Job 을 실행할지 결정하는 부분
    System.out.println("LoggingAfter10SecondsJob is running");
  }
}
