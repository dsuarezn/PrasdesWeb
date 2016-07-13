package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import co.gov.ideam.prasdes.dataservices.dao.PrasdesEquivDAO;
import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquiv;
import co.gov.ideam.prasdes.dataservices.entidades.PrasdesEquivPK;

@Repository
@Transactional
@Qualifier("prasdesEquivDAOImpl")
public class PrasdesEquivDAOImpl extends GenericDAOJPAImpl<PrasdesEquiv, PrasdesEquivPK> implements PrasdesEquivDAO {

	@Override
	public List<PrasdesEquiv> obtenerEquivalenciasPorParametros(String tipoValor, String ideamVal,
			String prasdesVal) {
		
		
		Query query = em.createNamedQuery("PrasdesEquiv.findByParams");
//		String pTipoValor = (!StringUtils.isEmpty(tipoValor)?tipoValor:"");
//		String pIdeamValor = (!StringUtils.isEmpty(ideamVal)?ideamVal:"");
//		String pPrasdesValor = (!StringUtils.isEmpty(prasdesVal)?prasdesVal:"");
		
		query.setParameter("tipoval", tipoValor);
		query.setParameter("ideamval", ideamVal);
		query.setParameter("prasdesval", prasdesVal);
		
		return (List<PrasdesEquiv>)query.getResultList();
		
	}

}
