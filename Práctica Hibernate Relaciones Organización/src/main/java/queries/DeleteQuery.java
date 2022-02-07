package queries;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import organizacion.Departamento;
import organizacion.HibernateUtil;

public class DeleteQuery {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		// Borre un departamento.
		String hql = "delete from organizacion.Departamento where id_depto = :id_depto";

		Query query = session.createQuery(hql);
		query.setParameter("id_depto", 11);

		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Deleted " + rowsAffected + " rows.");
		}

		// Departamentos
		String hql2 = "from Departamento";
		Query query2 = session.createQuery(hql2);
		List<Departamento> listDepartamentos = query2.getResultList();

		System.out.println("\n Tabla Departamento");
		for (Departamento i : listDepartamentos) {

			System.out.println(i.getId_depto() + " / " + i.getNom_dpto() + " / ");
		}

		t.commit();
		session.close();

	}

}
