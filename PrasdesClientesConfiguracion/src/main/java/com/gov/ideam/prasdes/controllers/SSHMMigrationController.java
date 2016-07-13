package com.gov.ideam.prasdes.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gov.ideam.prasdes.config.AppConfigInfo;
import com.gov.ideam.prasdes.rest.RestAdapter;

import co.gov.ideam.prasdes.dataservices.entidades.Period;
import co.gov.ideam.prasdes.utilidades.Utilidades;
import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;


@Controller
@RequestMapping("/sshm")
public class SSHMMigrationController {
	
	@Autowired
	private AppConfigInfo appConfigInfo;
	
	
	
	
	
	@Autowired
	private RestAdapter restAdapterImpl;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getMigracionSshmView(Model model){			
		return "sshm";
	}
	
	@CrossOrigin
	@RequestMapping(value = "/ideamPrasdes", method = RequestMethod.POST)
	public String getEjecutarMigracion(@RequestBody MigracionFormWebDTO webdto){
		
		webdto.setServiceUrl(obtenerSshmServiceUrl(webdto.getIdPeriod()));
		try {
			webdto=Utilidades.constructValidUrl(webdto);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}		
		restAdapterImpl.migrarInformacionIdeamToPrasdes(webdto.getServiceUrl(), webdto.getIdPeriod());
		return "sshm";
	}
	
	public String obtenerSshmServiceUrl(Long period){
		String urlService=null;
		if(period.equals(appConfigInfo.periodIdDailyData)){
			urlService = appConfigInfo.dailySshmDataGetServiceUrl;
		}
		else if(period.equals(appConfigInfo.periodIdInstantData)){
			urlService = appConfigInfo.instantSshmDataGetServiceUrl;
		}
		else if(period.equals(appConfigInfo.periodIdMonthlyData)){
			urlService = appConfigInfo.monthlySshmDataGetServiceUrl;
		}
		return urlService;
	}
		
	@ModelAttribute("listaPeriodos")
    public List<Period> periodList() {
        return restAdapterImpl.getPrasdesPeriods();
    }
}
