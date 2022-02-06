package queries;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import organizacion.HibernateUtil;

public class UpdateQuery {

	public static void main(String[] args) {

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		// Introduce nombre
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la ciudad de residencia del solicitante: ");
		String ciudad = sc.nextLine();

		try {
			System.out.println("Introduce el ID del solicitante: ");
			int id = sc.nextInt();

			String hql = "update Solicitante set ciudad = :ciudad where id = :id";

			Query query = session.createQuery(hql);
			query.setParameter("ciudad", ciudad);
			query.setParameter("id", id);

			int rowsAffected = query.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Updated " + rowsAffected + " rows.");
			}

			t.commit();

			session.close();
			sc.close();

		} catch (InputMismatchException ex) {
			System.out.println("La ID tiene que ser un entero: " + ex.getMessage());
		}
	}
}
