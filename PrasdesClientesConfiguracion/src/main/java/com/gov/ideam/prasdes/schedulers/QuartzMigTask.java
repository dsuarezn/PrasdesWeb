package com.gov.ideam.prasdes.schedulers;

import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

import com.gov.ideam.prasdes.config.AppConfigInfo;
import com.gov.ideam.prasdes.config.SpringContextBridge;
import com.gov.ideam.prasdes.rest.RestAdapterImpl;

import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.utilidades.Utilidades;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;


public class QuartzMigTask implements org.quartz.Job{
	
	private AppConfigInfo appConfigInfo;
	private RestAdapterImpl restAdapterImpl;
	
	private Trigger jobCronTrigger; 
	private JobDetail jobDetail;
	private MigTask migTask;	
	
	public QuartzMigTask() {		
	}
		
	public MigTask getMigTask() {
		return migTask;
	}

	public void setMigTask(MigTask migTask) {
		this.migTask = migTask;
	}

	public JobDetail getJobDetail() {
		return jobDetail;
	}

	public void setJobDetail(JobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}

	public QuartzMigTask(JobDetail jobd,Trigger trigger) {
		this.jobDetail=jobd;
		this.jobCronTrigger = trigger;		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {		
		appConfigInfo = SpringContextBridge.getAppConfigInfoInstance();
		restAdapterImpl = SpringContextBridge.getRestAdapterInstance();
		MigTask migTask = (MigTask) context.getJobDetail().getJobDataMap().get("migTask");
		MigracionFormWebDTO webdto = new MigracionFormWebDTO();
		webdto.setIdEstacion(migTask.getnIdstation());
		webdto.setIdPeriod(migTask.getnIdperiod());
		webdto.setIdCustomer(migTask.getvIdcustomer());
		webdto.setIdVariable(migTask.getnIdvar());
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(now); // Now use today date.
		c.add(Calendar.DATE,-migTask.getnCantidadDias().intValue());		
		webdto.setSfechaFin(Utilidades.formatearFecha(now));
		webdto.setSfechaInicio(Utilidades.formatearFecha(c.getTime()));
		webdto.setServiceUrl(migTask.getVUrl());
		try {
			
			webdto = Utilidades.constructValidUrl(webdto);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		if(migTask.getnIdperiod().equals(appConfigInfo.periodIdDailyData)){			
			List<ConsultaResponseDTO> data= restAdapterImpl.getPrasdesDailyData(webdto);
			restAdapterImpl.postPrasdesDailyData(data);
		}
		else if(migTask.getnIdperiod().equals(appConfigInfo.periodIdInstantData)){
			List<ConsultaResponseRawDataDTO> data= restAdapterImpl.getPrasdesInstantData(webdto);
			restAdapterImpl.postPrasdesInstantData(data);
		}
		else if(migTask.getnIdperiod().equals(appConfigInfo.periodIdMonthlyData)){
			List<ConsultaResponseDTO> data= restAdapterImpl.getPrasdesMonthlyData(webdto);
			restAdapterImpl.postPrasdesMonthlyData(data);
		}
		else if(migTask.getnIdperiod().equals(appConfigInfo.periodIdRawData)){
			List<ConsultaResponseRawDataDTO> data= restAdapterImpl.getPrasdesRawData(webdto);
			restAdapterImpl.postPrasdesRawData(data);
		}			
    }

	public Trigger getJobCronTrigger() {
		return jobCronTrigger;
	}

	public void setJobCronTrigger(Trigger jobCronTrigger) {
		this.jobCronTrigger = jobCronTrigger;
	}

	
	
}
