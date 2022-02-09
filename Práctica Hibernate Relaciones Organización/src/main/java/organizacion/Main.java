package organizacion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * 
 * @author Robert M.P.
 *
 */
public class Main {

	public static void main(String[] args) {

		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder registry = new StandardServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		registry.build();

		// obtains the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();

		for (int i = 1; i <= 2; i++) {

			Sede sede = new Sede("Sede - " + i);
			session.save(sede);

			for (int a = 1; a <= 3; a++) {
				Departamento departamento = new Departamento("Departamento: " + a, sede.getId_sede(), sede);
				session.save(departamento);

				for (int b = 1; b <= 4; b++) {
					Empleado empleado = new Empleado("02720" + a + i + b + "V", "Empleado: " + b,
							departamento);
					Empleado_datos_prof edp = new Empleado_datos_prof(empleado.getDni(), "" + b, 1200 + b, empleado);
					session.save(empleado);
					session.save(edp);
				}
			}

			for (int z = 1; z <= 3; z++) {
				Proyecto proyecto = new Proyecto(null, null, "Proyecto 000" + z);
				proyecto.add_sede(sede);
				session.save(proyecto);
			}
		}

		t.commit();

		session.close();
	}
}