package queries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import organizacion.Departamento;
import organizacion.Empleado;
import organizacion.HibernateUtil;
import organizacion.Proyecto;
import organizacion.Sede;

public class SelectQuery {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		// Sedes
		String hql1 = "from Sede";
		Query query1 = session.createQuery(hql1);
		List<Sede> listSede = query1.getResultList();

		System.out.println("\n Tabla Sede");
		for (Sede i : listSede) {

			System.out.println(i.getId_sede() + " / " + i.getNom_sede() + " / ");
		}
		System.out.println("\n");

		// Departamentos

		String hql2 = "from Departamento";
		Query query2 = session.createQuery(hql2);
		List<Departamento> listDepartamentos = query2.getResultList();

		System.out.println("\n Tabla Departamento");
		for (Departamento i : listDepartamentos) {

			System.out.println(i.getId_depto() + " / " + i.getNom_dpto() + " / ");
		}

		// Empleados
		String hql3 = "from Empleado";
		Query query3 = session.createQuery(hql3);
		List<Empleado> listEmpleado = query3.getResultList();

		System.out.println("\n Tabla Empleado");
		for (Empleado i : listEmpleado) {

			System.out.println(i.getDni() + " / " + i.getNom_emp() + " / ");
		}

		// Proyectos
		String hql4 = "from Proyecto ";
		Query query4 = session.createQuery(hql4);
		List<Proyecto> listCategories3 = query3.getResultList();

		System.out.println("\n Tabla Proyecto");
		for (Proyecto i : listCategories3) {

			System.out.println(i.getId_proy() + " / " + i.getNom_proy());
		}

		t.commit();
		session.close();
	}
}
