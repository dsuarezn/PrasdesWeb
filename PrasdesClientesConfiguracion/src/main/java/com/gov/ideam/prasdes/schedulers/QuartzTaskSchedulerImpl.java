package com.gov.ideam.prasdes.schedulers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import com.gov.ideam.prasdes.rest.RestAdapterImpl;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;

@Component
@Qualifier("quartzTaskSchedulerImpl")
@DependsOn("restAdapterImpl")
public class QuartzTaskSchedulerImpl implements QuartzTaskScheduler, InitializingBean {
	
	static final Logger logger = LogManager.getLogger(QuartzTaskSchedulerImpl.class.getName());
	 
	@Autowired
	private RestAdapterImpl restAdapterImpl;
	
	@Autowired
	private FixedBackOffPolicy fixedBackOffPolicy;

	@Autowired
	private ExceptionClassifierRetryPolicy exceptionClassifierRetryPolicy;

	

	private Scheduler scheduler;
	
	public List<QuartzMigTask> jobList;

	
	public QuartzTaskSchedulerImpl() {
		super();			
	}


    
	
	public void initScheduler(){		
		try {
			scheduler = new StdSchedulerFactory().getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	//@PostConstruct	
	public String initStoredTasks(){
		System.out.println("Intento de recobrar procesos....");
		List<MigTaskDTO> storedTasks = restAdapterImpl.getPrasdesTasks();
		jobList = constructJobListFromMigTaskDTO(storedTasks);
		scheduleJobList(jobList);
		startJobs();	
		System.out.println("Loaded and started processes....");
		return "Loaded and started proceses....";
	}
		
	public void startJobs(){
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void scheduleAndStartJob(MigTask task){
		QuartzMigTask qMigTask = getQuartzMigTask(task);
		try {
			scheduler.scheduleJob(qMigTask.getJobDetail(), qMigTask.getJobCronTrigger());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public void scheduleJobList(List<QuartzMigTask> listaJobs){	
		for (QuartzMigTask quartzMigTask : listaJobs) {
			try {				
				scheduler.scheduleJob(quartzMigTask.getJobDetail(), quartzMigTask.getJobCronTrigger());
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public QuartzMigTask getQuartzMigTask(MigTask migTask){
		JobDataMap data = new JobDataMap();
		data.put("migTask", migTask);

		JobDetail job =  JobBuilder.newJob(QuartzMigTask.class).setJobData(data)
				.withIdentity(new JobKey(migTask.getnTaskId().toString())).build();
		
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(migTask.getnTaskId().toString())
				.withSchedule(
					CronScheduleBuilder.cronSchedule(migTask.getVExpresion()))
				.build();
		return new QuartzMigTask(job, trigger);
	}
	
	public QuartzMigTask getQuartzMigTask(MigTaskDTO migTask){
		JobDataMap data = new JobDataMap();
		data.put("migTask", migTask.getInnerTask());
		JobDetail job =  JobBuilder.newJob(QuartzMigTask.class).setJobData(data)
				.withIdentity(new JobKey(migTask.getnTaskId().toString())).build();
		Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity(migTask.getnTaskId().toString())
				.withSchedule(
					CronScheduleBuilder.cronSchedule(migTask.getvExpresion()))
				.build();
		return new QuartzMigTask(job, trigger);
	}
		
	public List<QuartzMigTask> constructJobListFromMigTask(List<MigTask> storedMigTask){
		List<QuartzMigTask> lista=new ArrayList<QuartzMigTask>();
		for (MigTask migTask : storedMigTask) {			
			lista.add(getQuartzMigTask(migTask));
		}
		return lista;
	}
	
	public List<QuartzMigTask> constructJobListFromMigTaskDTO(List<MigTaskDTO> storedMigTask){
		List<QuartzMigTask> lista=new ArrayList<QuartzMigTask>();
		for (MigTaskDTO migTask : storedMigTask) {			
			lista.add(getQuartzMigTask(migTask));
		}
		return lista;
	}

	public List<QuartzMigTask> getJobList() {
		return jobList;
	}

	public void setJobList(List<QuartzMigTask> jobList) {
		this.jobList = jobList;
	}
	
	public void deleteJob(MigTask task){
		try {
			scheduler.deleteJob(new JobKey(task.getnTaskId().toString()));
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		initScheduler();		
		try {
	    	methodToInvoke();
		} catch (Exception e) {
			System.out.println("Error loading stored tasks....");
		}		
	}
	
	public QuartzTaskSchedulerImpl getQuartzTaskSchedulerImpl(){
		return this;
	}
	 
	@SuppressWarnings("unchecked")
	public void methodToInvoke() {		 
        try {
        	final RetryTemplate retryTemplate = new RetryTemplate();        	
        	retryTemplate.setBackOffPolicy( fixedBackOffPolicy );
        	retryTemplate.setRetryPolicy( exceptionClassifierRetryPolicy );         	
            retryTemplate.execute(new RetryCallback() {            	                
               @Override
	            public String doWithRetry(RetryContext context) throws Throwable {	            	
            	   System.out.println(String.format("\tRetry count ->  %s ",context.getRetryCount()));            	    
            	    	return getQuartzTaskSchedulerImpl().initStoredTasks();
	            }
            });
        } catch (Throwable e) {
//            e.printStackTrace();
        	
            System.out.println("Error loading stored tasks....");
        } 
    }
   
	
	
}
