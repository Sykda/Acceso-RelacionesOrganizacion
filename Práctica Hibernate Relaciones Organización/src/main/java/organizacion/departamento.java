package organizacion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class departamento {

	private int id_depto;
	private String nom_dpto;
	private int id_sede;

	public departamento(int id_depto, String nom_dpto, int id_sede) {
		super();
		this.id_depto = id_depto;
		this.nom_dpto = nom_dpto;
		this.id_sede = id_sede;
	}

	@Id
	
	public int getId_depto() {
		return id_depto;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public String getNom_dpto() {
		return nom_dpto;
	}

	public void setNom_dpto(String nom_dpto) {
		this.nom_dpto = nom_dpto;
	}

	public int getId_sede() {
		return id_sede;
	}

	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
	}

}
