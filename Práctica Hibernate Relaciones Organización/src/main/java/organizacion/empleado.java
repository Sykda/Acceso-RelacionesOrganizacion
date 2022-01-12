package organizacion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class empleado {

	private String dni;
	private String nom_emp;
	private int id_depto;
	private empleado_datos_prof datosEmpleado;

	

	public empleado() {
		super();
	}

	@Id	
	public String getDni() {
		return dni;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	public empleado_datos_prof getDatosEmpleado() {
		return datosEmpleado;
	}

	public void setDatosEmpleado(empleado_datos_prof datosEmpleado) {
		this.datosEmpleado = datosEmpleado;
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
