package co.gov.ideam.prasdes.dataservices.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import co.gov.ideam.prasdes.dataservices.dao.GenericDAOInterface;


public class GenericDAOJPAImpl<T, PK extends Serializable> extends CommonDAOImpl
	implements GenericDAOInterface<T, PK> 
	{

	protected Class<T> entityClass;
	
	@PersistenceContext
    protected EntityManager em;
	
	 public GenericDAOJPAImpl() {
	        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
	        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	    }
	
	@Override
	public T create(T newInstance) {
		 this.em.persist(newInstance);
	        return newInstance;
	}

	@Override
	public T read(PK id) {
		 return this.em.find(entityClass, id);
	}

	@Override
	public T update(T transientObject) {
		  return this.em.merge(transientObject);		
	}

	@Override
	public void delete(T persistentObject) {
		persistentObject = this.em.merge(persistentObject);
		this.em.remove(persistentObject);
	}


}
