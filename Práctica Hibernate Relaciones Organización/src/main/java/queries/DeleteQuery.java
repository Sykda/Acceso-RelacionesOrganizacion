package queries;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import organizacion.HibernateUtil;

public class DeleteQuery {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		// Introduce nombre
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre a borrar: ");
		String nombre = sc.nextLine();

		// Query
		String hql = "delete from Solicitante where nombre = :nombre";

		Query query = session.createQuery(hql);
		query.setParameter("nombre", nombre);

		int rowsAffected = query.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("Deleted " + rowsAffected + " rows.");
		}

		t.commit();
		session.close();
		sc.close();
	}

}
