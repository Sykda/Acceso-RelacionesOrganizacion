package organizacion;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Empleado {

	private String dni;
	private String nom_emp;
	private Empleado_datos_prof datosEmpleado;
	private Departamento departamento;

	public Empleado(String dni, String nom_emp, Departamento departamento) {
		super();
		this.dni = dni;
		this.nom_emp = nom_emp;
		this.departamento = departamento;
	}

	public Empleado() {
		super();
	}

	@Id
	@Column
	public String getDni() {
		return dni;
	}

	@OneToOne(mappedBy = "empleado")
	public Empleado_datos_prof getDatosEmpleado() {
		return datosEmpleado;
	}

	@ManyToOne
	public Departamento getDepartamento() {
		return departamento;
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

	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}

}
