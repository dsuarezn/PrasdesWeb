package co.gov.ideam.prasdes.dataservices.dao;

import java.io.Serializable;
import java.util.Collection;


public interface GenericDAOInterface <T, PK extends Serializable>{
	 /** persiste la nueva instancia del objeto en la base de datos */
    T create(T newInstance);

    /** obtiene el objeto por la llave primaria     *   
     */
    T read(PK id);

    /** guarda los cambios a un objeto persistido  */
    T update(T transientObject);

    /** elimina un objeto persistido */
    void delete(T persistentObject);

	

}
