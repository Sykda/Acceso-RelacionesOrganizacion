package organizacion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class sede {

	private int id_sede;
	private String nom_sede;

	public sede(int id_sede, String nom_sede) {
		super();
		this.id_sede = id_sede;
		this.nom_sede = nom_sede;
	}

	@Id
	public int getId_sede() {
		return id_sede;
	}

	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
	}

	public String getNom_sede() {
		return nom_sede;
	}

	public void setNom_sede(String nom_sede) {
		this.nom_sede = nom_sede;
	}

}
