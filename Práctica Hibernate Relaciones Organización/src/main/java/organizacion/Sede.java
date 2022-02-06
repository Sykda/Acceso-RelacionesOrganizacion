package organizacion;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Sede {

	private int id_sede;
	private String nom_sede;
	private Set<Departamento> departamentos = new HashSet<Departamento>();
	private Set<Proyecto> proyectos = new HashSet<Proyecto>();

	public Sede(String nom_sede) {
		super();
		this.nom_sede = nom_sede;
	}
	

	@Id
	@Column
	@GeneratedValue
	public int getId_sede() {
		return id_sede;
	}

	@OneToMany(mappedBy = "sede", cascade = CascadeType.ALL)
	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	@ManyToMany(mappedBy = "sedes")
	public Set<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
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
