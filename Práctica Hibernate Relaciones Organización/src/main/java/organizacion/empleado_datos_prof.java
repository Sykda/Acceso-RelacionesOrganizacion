package organizacion;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class empleado_datos_prof {

	private int dni;
	private String categoria;
	private double sueldo_bruto_anual;

	public empleado_datos_prof(int dni, String categoria, double sueldo_bruto_anual) {
		super();
		this.dni = dni;
		this.categoria = categoria;
		this.sueldo_bruto_anual = sueldo_bruto_anual;
	}

	@Id
	@OneToOne(mappedBy = "dni")
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getSueldo_bruto_anual() {
		return sueldo_bruto_anual;
	}

	public void setSueldo_bruto_anual(double sueldo_bruto_anual) {
		this.sueldo_bruto_anual = sueldo_bruto_anual;
	}

}
