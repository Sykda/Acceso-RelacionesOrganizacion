package organizacion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Proyecto {

	private int id_proy;
	private Date f_inicio;
	private Date f_fin;
	private String nom_proy;
	private Set<Sede> sedes = new HashSet<Sede>();

	public Proyecto(Date f_inicio, Date f_fin, String nom_proy) {
		super();
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
		this.nom_proy = nom_proy;
	}

	@Id
	@Column
	@GeneratedValue
	public int getId_proy() {
		return id_proy;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Set<Sede> getSedes() {
		return sedes;
	}

	public void add_sede(Sede s) {
		sedes.add(s);
	}

	public void setSedes(Set<Sede> sedes) {
		this.sedes = sedes;
	}

	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	public Date getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(Date f_inicio) {
		this.f_inicio = f_inicio;
	}

	public Date getF_fin() {
		return f_fin;
	}

	public void setF_fin(Date f_fin) {
		this.f_fin = f_fin;
	}

	public String getNom_proy() {
		return nom_proy;
	}

	public void setNom_proy(String nom_proy) {
		this.nom_proy = nom_proy;
	}

}
