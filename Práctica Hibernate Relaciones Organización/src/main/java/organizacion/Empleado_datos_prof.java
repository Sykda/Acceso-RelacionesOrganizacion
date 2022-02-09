package organizacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table
public class Empleado_datos_prof {

	private String dni;
	private String categoria;
	private double sueldo_bruto_anual;
	Empleado empleado;

	public Empleado_datos_prof(String dni, String categoria, double sueldo_bruto_anual, Empleado empleado) {
		super();
		this.dni = dni;
		this.categoria = categoria;
		this.sueldo_bruto_anual = sueldo_bruto_anual;
		this.empleado=empleado;
		
	}

	@Id
	@Column
	public String getDni() {
		return dni;
	}

	@OneToOne
	@OnDelete( action = OnDeleteAction.CASCADE )
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public Empleado_datos_prof() {
		super();
	}

	public String getCategoria() {
		return categoria;
	}

	public double getSueldo_bruto_anual() {
		return sueldo_bruto_anual;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public void setSueldo_bruto_anual(double sueldo_bruto_anual) {
		this.sueldo_bruto_anual = sueldo_bruto_anual;
	}

}
