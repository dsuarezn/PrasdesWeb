package co.gov.ideam.prasdes.dataservices.entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the GRDTBP_PRASDES_EQUIV database table.
 * 
 */
@Entity
@Table(name="GRDTBP_PRASDES_EQUIV")
@NamedQueries({
	@NamedQuery(name="PrasdesEquiv.findAll", query="SELECT g FROM PrasdesEquiv g"),
	@NamedQuery(name="PrasdesEquiv.findByParams", 
	query="SELECT g FROM PrasdesEquiv g WHERE (g.id.tipoVal = :tipoval OR :tipoval is null) AND (g.id.ideamVal = :ideamval OR :ideamval is null) AND (g.id.prasdesVal = :prasdesval OR :prasdesval is null)")
})
public class PrasdesEquiv implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PrasdesEquivPK id;

	public PrasdesEquiv() {
	}

	public PrasdesEquivPK getId() {
		return this.id;
	}

	public void setId(PrasdesEquivPK id) {
		this.id = id;
	}

}