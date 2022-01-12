package organizacion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class empleado_datos_prof {

	private String dni;
	private String categoria;
	private double sueldo_bruto_anual;
	empleado empleado;

	public empleado_datos_prof() {
		super();
	}

	@Id
	@Column
	public String getDni() {
		return dni;
	}

	@OneToOne(mappedBy = "datosEmpleado")
	public empleado getEmpleado() {
		return empleado;
	}

	public String getCategoria() {
		return categoria;
	}

	public double getSueldo_bruto_anual() {
		return sueldo_bruto_anual;
	}

	public void setEmpleado(empleado empleado) {
		this.empleado = empleado;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setSueldo_bruto_anual(double sueldo_bruto_anual) {
		this.sueldo_bruto_anual = sueldo_bruto_anual;
	}

}
