package com.gov.ideam.prasdes.quartz;

import org.junit.Test;

import com.gov.ideam.prasdes.schedulers.QuartzTaskSchedulerImpl;

public class QuartzSchedulerTest {

	@Test
	public void quartzSchedulerTest(){
		QuartzTaskSchedulerImpl tasker = new QuartzTaskSchedulerImpl();
		tasker.initScheduler();
		assert( tasker.jobList.size()> 0);
	}
	
}
