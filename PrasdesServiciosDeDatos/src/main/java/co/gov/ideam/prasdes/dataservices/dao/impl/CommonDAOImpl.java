package co.gov.ideam.prasdes.dataservices.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonDAOImpl {

	@Value("${limites.limiteRegistrosInstananeos}")
	protected Integer limiteRegistrosInstananeos;
	
	@Value("${limites.limiteRegistrosDiarios}")
	protected Integer limiteRegistrosDiarios;
	
	@Value("${limites.limiteRegistrosMensuales}")
	protected Integer limiteRegistrosMensuales;

	@Value("${hibernate.jdbc.batch_size}")
	protected int batchSize;
	
	@Value("${limites.limiteRegistrosInstananeos}")
	protected Integer limiteRegistrosCrudos;
	
	@Value("${prasdes.aceptarNulos}")
	protected boolean aceptarNulos;
}
