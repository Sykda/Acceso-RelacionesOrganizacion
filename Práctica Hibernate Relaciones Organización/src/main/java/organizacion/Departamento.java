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
	private int id_sede;
	private Set<Empleado> empleados = new HashSet<Empleado>();
	Sede sede;

	public Departamento(String nom_dpto, int id_sede, Sede sede) {
		super();
		this.nom_dpto = nom_dpto;
		this.id_sede = id_sede;
		this.sede = sede;
	}

	public Departamento() {
		super();
	}

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	@Id
	@Column
	@GeneratedValue
	public int getId_depto() {
		return id_depto;
	}

	public int getId_sede() {
		return id_sede;
	}

	public String getNom_dpto() {
		return nom_dpto;
	}

	@ManyToOne
	public Sede getSede() {
		return sede;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	public void setId_depto(int id_depto) {
		this.id_depto = id_depto;
	}

	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
	}

	public void setNom_dpto(String nom_dpto) {
		this.nom_dpto = nom_dpto;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

}
