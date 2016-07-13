package com.gov.ideam.prasdes.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Qualifier("appConfigInfo")
public class AppConfigInfo {
	


	@Value("${serviceurl.migTask}")
    public String migTaskServiceUrl;	
	
	@Value("${serviceurl.connection}")
	public String connectionServiceUrl;
	
	@Value("${serviceurl.customerstationvar}")
	public String customerStationVarServiceUrl;
	
	@Value("${serviceurl.station}")
	public String stationServiceUrl;
	
	@Value("${serviceurl.variable}")
	public String variableServiceUrl;
	
	@Value("${serviceurl.customerwebserv}")
	public String customerWebServServiceUrl;
	
	@Value("${serviceurl.countryServiceUrl}")
	public String countryServiceUrl;
	
	@Value("${serviceurl.get.equiv.station}")
	public String equivStationsServiceUrl;
	
	@Value("${serviceurl.get.equiv.variable}")
	public String equivVariablesServiceUrl;
	
	@Value("${serviceurl.get.equiv.source}")
	public String equivSourcesServiceUrl;
	

	@Value("${serviceurl.get.equiv.quality}")
	public String equivQualityServiceUrl;
	
	
	@Value("${serviceurl.period}")
	public String periodServiceUrl;
	
	@Value("${serviceurl.instantData}")
	public String instantDataServiceUrl;
	
	@Value("${serviceurl.dailyData}")
	public String dailyDataServiceUrl;
	
	@Value("${serviceurl.monthlyData}")
	public String monthlyDataServiceUrl;
	
	@Value("${serviceurl.rawData}")
	public String rawDataPostServiceUrl;
	
	@Value("${periodId.dailyData}")
	public Long periodIdDailyData;
	
	@Value("${periodId.instantData}")
    public Long periodIdInstantData;
	
	@Value("${periodId.monthlyData}")
    public Long periodIdMonthlyData;
	
	@Value("${periodId.rawData}")
    public Long periodIdRawData;
	
	
	@Value("${serviceurl.get.sshm.instantData}")
	public String instantSshmDataGetServiceUrl;
	
	@Value("${serviceurl.get.sshm.dailyData}")
	public String dailySshmDataGetServiceUrl;
	
	@Value("${serviceurl.get.sshm.monthlyData}")
	public String monthlySshmDataGetServiceUrl;
	
	@Value("${prasdes.sshmdefaultusermigration}")
	public Long prasdesDefaultUser;

	@Override
	public String toString() {
		return "AppConfigInfo [migTaskServiceUrl=" + migTaskServiceUrl + ", connectionServiceUrl="
				+ connectionServiceUrl + ", customerStationVarServiceUrl=" + customerStationVarServiceUrl
				+ ", stationServiceUrl=" + stationServiceUrl + ", variableServiceUrl=" + variableServiceUrl
				+ ", customerWebServServiceUrl=" + customerWebServServiceUrl + ", countryServiceUrl="
				+ countryServiceUrl + ", equivStationsServiceUrl=" + equivStationsServiceUrl
				+ ", equivVariablesServiceUrl=" + equivVariablesServiceUrl + ", equivSourcesServiceUrl="
				+ equivSourcesServiceUrl + ", periodServiceUrl=" + periodServiceUrl + ", instantDataServiceUrl="
				+ instantDataServiceUrl + ", dailyDataServiceUrl=" + dailyDataServiceUrl + ", monthlyDataServiceUrl="
				+ monthlyDataServiceUrl + ", rawDataPostServiceUrl=" + rawDataPostServiceUrl + ", periodIdDailyData="
				+ periodIdDailyData + ", periodIdInstantData=" + periodIdInstantData + ", periodIdMonthlyData="
				+ periodIdMonthlyData + ", periodIdRawData=" + periodIdRawData + ", instantSshmDataGetServiceUrl="
				+ instantSshmDataGetServiceUrl + ", dailySshmDataGetServiceUrl=" + dailySshmDataGetServiceUrl
				+ ", monthlySshmDataGetServiceUrl=" + monthlySshmDataGetServiceUrl + "]";
	}
	
	
	
}
