package com.gov.ideam.prasdes.schedulers;

import java.util.List;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.web.dto.MigTaskDTO;

public interface QuartzTaskScheduler {

	public void initScheduler();
	public void startJobs();
	public void scheduleJobList(List<QuartzMigTask> listaJobs);
	public List<QuartzMigTask> constructJobListFromMigTask(List<MigTask> storedMigTask);
	public List<QuartzMigTask> constructJobListFromMigTaskDTO(List<MigTaskDTO> storedMigTask);
	public List<QuartzMigTask> getJobList();
	public void setJobList(List<QuartzMigTask> jobList);
	public void deleteJob(MigTask task);
	public QuartzMigTask getQuartzMigTask(MigTask migTask);
	public void scheduleAndStartJob(MigTask task);
	
	
}
