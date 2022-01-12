package organizacion;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * This program demonstrates using JPA annotations in Hibernate in order to
 * implement a one-to-many association mapping.
 * 
 * @author www.codejava.net
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
		Transaction t= session.beginTransaction();
		
		empleado e1 = new empleado();
		e1.setDni("02720917v");
		e1.setNom_emp("pedro");
		
		
		empleado_datos_prof d1= new empleado_datos_prof(); 
		d1.setCategoria("Becario");
		d1.setDni("02720917V");
		d1.setSueldo_bruto_anual(12000);
		
		e1.setDatosEmpleado(d1);
		
		session.save(e1);
		session.save(d1);
				
				
				
		t.commit();

		
		session.close();
	}
}