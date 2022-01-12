package organizacion;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class proyecto_sede {

	private int id_proy;
	private int id_sede;
	private Date f_inicio;
	private Date f_fin;

	public proyecto_sede(int id_proy, int id_sede, Date f_inicio, Date f_fin) {
		super();
		this.id_proy = id_proy;
		this.id_sede = id_sede;
		this.f_inicio = f_inicio;
		this.f_fin = f_fin;
	}

	@Id
	public int getId_proy() {
		return id_proy;
	}

	public void setId_proy(int id_proy) {
		this.id_proy = id_proy;
	}

	
	public int getId_sede() {
		return id_sede;
	}

	public void setId_sede(int id_sede) {
		this.id_sede = id_sede;
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

}
