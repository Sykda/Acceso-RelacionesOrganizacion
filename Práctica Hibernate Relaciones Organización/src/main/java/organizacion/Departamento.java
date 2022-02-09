package organizacion;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Departamento {

	private int id_depto;
	private String nom_dpto;

	private Set<Empleado> empleados = new HashSet<Empleado>();
	Sede sede;

	public Departamento(String nom_dpto, Sede sede) {
		super();
		this.nom_dpto = nom_dpto;

		this.sede = sede;
	}

	public Departamento() {
		super();
	}

	@Id
	@Column
	@GeneratedValue
	public int getId_depto() {
		return id_depto;
	}

	@OneToMany(mappedBy = "departamento", cascade=CascadeType.ALL)
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	@ManyToOne
	public Sede getSede() {
		return sede;
	}

	public String getNom_dpto() {
		return nom_dpto;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public void setNom_dpto(String nom_dpto) {
		this.nom_dpto = nom_dpto;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}
