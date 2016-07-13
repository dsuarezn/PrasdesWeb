package com.gov.ideam.prasdes.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.util.StringUtils;

import com.gov.ideam.prasdes.config.AppConfigInfo;
import com.gov.ideam.prasdes.rest.RestAdapter;

import ch.qos.logback.classic.pattern.Util;
import co.gov.ideam.prasdes.dataservices.entidades.Customerwebserv;
import co.gov.ideam.prasdes.utilidades.UrlEncodedQueryString;
import co.gov.ideam.prasdes.utilidades.Utilidades;
import co.gov.ideam.prasdes.web.dto.ConnectionDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseDTO;
import co.gov.ideam.prasdes.web.dto.ConsultaResponseRawDataDTO;
import co.gov.ideam.prasdes.web.dto.MigracionFormWebDTO;
import scala.annotation.meta.setter;

@Controller
@CrossOrigin
@RequestMapping("/manual")
public class ClienteMigracionController  {
	
	@Autowired
	private AppConfigInfo appConfigInfo;
	
	@Autowired
	private RestAdapter restAdapterImpl;
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getMigracionView(Model model){
//		System.out.println("entro en controller");
//		
		return "manual";
	}
	
	@ModelAttribute("listaConexiones")
    public List<ConnectionDTO> customerList() {		
        return restAdapterImpl.getPrasdesConnections();
    }
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.POST)
	public void migrarInformacion(@RequestBody MigracionFormWebDTO webdto){			
		try {
			webdto=Utilidades.constructValidUrl(webdto);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		if(webdto.getIdPeriod().equals(appConfigInfo.periodIdDailyData)){
			List<ConsultaResponseDTO> data= restAdapterImpl.getPrasdesDailyData(webdto);
			restAdapterImpl.postPrasdesDailyData(data);
		}
		else if(webdto.getIdPeriod().equals(appConfigInfo.periodIdInstantData)){
			List<ConsultaResponseRawDataDTO> data= restAdapterImpl.getPrasdesInstantData(webdto);
			restAdapterImpl.postPrasdesInstantData(data);
		}
		else if(webdto.getIdPeriod().equals(appConfigInfo.periodIdMonthlyData)){
			List<ConsultaResponseDTO> data= restAdapterImpl.getPrasdesMonthlyData(webdto);
			restAdapterImpl.postPrasdesMonthlyData(data);
		}
		else if(webdto.getIdPeriod().equals(appConfigInfo.periodIdRawData)){
			List<ConsultaResponseRawDataDTO> data= restAdapterImpl.getPrasdesRawData(webdto);
			restAdapterImpl.postPrasdesRawData(data);
		}				
	}
	
	
	
	
	
}