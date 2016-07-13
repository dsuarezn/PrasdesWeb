package com.gov.ideam.prasdes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.gov.ideam.prasdes.config.AppConfigInfo;
import com.gov.ideam.prasdes.rest.RestAdapter;
import com.gov.ideam.prasdes.schedulers.QuartzTaskScheduler;

import co.gov.ideam.prasdes.dataservices.entidades.Country;
import co.gov.ideam.prasdes.dataservices.entidades.MigTask;
import co.gov.ideam.prasdes.dataservices.entidades.Period;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;
import co.gov.ideam.prasdes.web.dto.ScheduledMigTaskDTO;

@Controller
@RequestMapping("/programador")
public class ScheduledMigTaskController {

	@Autowired
	private AppConfigInfo appConfigInfo;
	
	@Autowired
	private RestAdapter restAdapterImpl;
	
	@Autowired
	private QuartzTaskScheduler quartzTaskSchedulerImpl;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getScheduledMigracionView(Model model){				
//		model.addAttribute("listaTareas", restAdapterImpl.getPrasdesTasks());
		//Atributo añadido obligatoriamente para que no se reviente thymeleaf (por el binding de atributos)
		model.addAttribute("jobdto",new ScheduledMigTaskDTO());
		model.addAttribute("mensajeError","");
		return "automatic";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postMigracionTask(Model model,@RequestBody ScheduledMigTaskDTO jobdto){
		MigTask task = new MigTask(jobdto.getExpresion());
		
		task.setnCantidadDias(jobdto.getNoDays());
		task.setnIdperiod(jobdto.getIdPeriod());
		task.setnIdstation(jobdto.getIdStation());
		task.setvIdcustomer(jobdto.getIdCustomer());
		task.setVUrl(jobdto.getServiceUrl());
		task.setnUrlIdCountry(jobdto.getIdCountry());
		task = restAdapterImpl.postPrasdesTasks(task);
		quartzTaskSchedulerImpl.scheduleAndStartJob(task);	
		model.addAttribute("jobdto",new ScheduledMigTaskDTO());
		return "automatic";
	}
	
	@ModelAttribute("listaConexiones")
    public List<ConnectionDTO> customerList() {		
        return restAdapterImpl.getPrasdesConnections();
    }
	
	@RequestMapping(value = "/{jobId}", method = RequestMethod.DELETE)
	public String deleteMigracionTask(Model model,@PathVariable("jobId") Long jobId){
		restAdapterImpl.deletePrasdesTasks(new MigTask(jobId));
		model.addAttribute("mensajeError","");
		return "automatic";
	}
	
	@ModelAttribute("listaPaises")
    public List<Country> countryList() {
        return restAdapterImpl.getPrasdesCountrys();
    }
	
	@ModelAttribute("listaPeriodos")
    public List<Period> periodList() {
        return restAdapterImpl.getPrasdesPeriods();
    }
	
	@CrossOrigin
	@RequestMapping(value = "/rutaTareas", produces = "application/json")	
    public @ResponseBody String taskListRoute() {
		System.out.println("dato:"+appConfigInfo.migTaskServiceUrl);
		String jsonStr = "[{\"rutaTareas\":\""+appConfigInfo.migTaskServiceUrl+"\"}]";
        return jsonStr;
    }
	
}
