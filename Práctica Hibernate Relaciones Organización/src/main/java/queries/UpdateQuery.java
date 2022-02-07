package queries;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import organizacion.HibernateUtil;
import organizacion.Proyecto;

public class UpdateQuery {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		// Modifique el sueldo de otro empleado para que supere el sueldo del empleado
		// con mayor sueldo y muéstrelo.
		String hql = "update organizacion.Empleado_datos_prof set sueldo_bruto_anual = :sueldo where dni = :dni";
		Query query = session.createQuery(hql);
		query.setParameter("sueldo", 5000.0);
		query.setParameter("dni", "02720324V");

		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Updated " + rowsAffected + " rows.");
		}

		// El empleado con mayor sueldo.
		String hql7 = "Select empleado.nom_emp, MAX(empleado_datos_prof.sueldo_bruto_anual)\r\n" + "from empleado \r\n"
				+ "join empleado_datos_prof\r\n" + "on empleado.dni= empleado_datos_prof.dni";
		Query query7 = session.createNativeQuery(hql7);
		List<Object[]> listEmpleadosMayorSuelo = query7.getResultList();

		System.out.println("\n Tabla El empleado con mayor sueldo.");
		for (Object[] i : listEmpleadosMayorSuelo) {

			System.out.println(i[0] + " / " + i[1]);
		}

		// Actualice el nombre de un proyecto.
		String hql2 = "update organizacion.Proyecto set nom_proy = :nom_proy where id_proy = :id_proy";
		Query query2 = session.createQuery(hql2);
		query2.setParameter("nom_proy", "APP FIN DE CURSO");
		query2.setParameter("id_proy", 5);

		int rowsAffected2 = query2.executeUpdate();
		if (rowsAffected2 > 0) {
			System.out.println("Updated " + rowsAffected2 + " rows.");
		}

		// Proyectos
		String hql4 = "from Proyecto ";
		Query query4 = session.createQuery(hql4);
		List<Proyecto> listProyecto = query4.getResultList();

		System.out.println("\n Tabla Proyecto");
		for (Proyecto i : listProyecto) {

			System.out.println(i.getId_proy() + " / " + i.getNom_proy());
		}

		t.commit();
		session.close();

	}
}
