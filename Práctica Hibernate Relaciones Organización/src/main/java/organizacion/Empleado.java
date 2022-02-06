package organizacion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Empleado {

	private String dni;
	private String nom_emp;
	private int id_depto;
	private Empleado_datos_prof datosEmpleado;
	Departamento departamento;

	public Empleado(String dni, String nom_emp, int id_depto) {
		super();
		this.dni = dni;
		this.nom_emp = nom_emp;
		this.id_depto = id_depto;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Empleado_datos_prof getDatosEmpleado() {
		return datosEmpleado;
	}

	@ManyToOne
	public Departamento getDepartamento() {
		return departamento;
	}

	@Id
	@Column
	public String getDni() {
		return dni;
	}

	public int getId_depto() {
		return id_depto;
	}

	public String getNom_emp() {
		return nom_emp;
	}

	public void setDatosEmpleado(Empleado_datos_prof datosEmpleado) {
		this.datosEmpleado = datosEmpleado;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}

}
