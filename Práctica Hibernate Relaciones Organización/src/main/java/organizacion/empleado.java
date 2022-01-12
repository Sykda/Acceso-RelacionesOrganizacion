package organizacion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class empleado {

	private String dni;
	private String nom_emp;
	private int id_depto;

	public empleado(String dni, String nom_emp, int id_depto) {
		super();
		this.dni = dni;
		this.nom_emp = nom_emp;
		this.id_depto = id_depto;
	}

	@Id
	@OneToOne
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_emp() {
		return nom_emp;
	}

	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}

	public int getId_depto() {
		return id_depto;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

}
