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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		List<Proyecto> listProyecto = query4.getResultList();

		System.out.println("\n Tabla Proyecto");
		for (Proyecto i : listProyecto) {

			System.out.println(i.getId_proy() + " / " + i.getNom_proy());
		}

		// Número de empleados y proyectos por sede.
		String hql5 = "Select  count(distinct empleado.dni),count(distinct proyecto.id_proy), sede.id_sede \r\n"
				+ "from empleado \r\n" + "join departamento\r\n" + "on empleado.id_depto=departamento.id_depto\r\n"
				+ "join sede\r\n" + "on departamento.id_sede= sede.id_sede\r\n" + "join proyecto_sede \r\n"
				+ "on sede.id_sede=proyecto_sede.sedes_id_sede\r\n" + "join proyecto\r\n"
				+ "on proyecto_sede.proyectos_id_proy=proyecto.id_proy\r\n" + "group by sede.id_sede;";
		Query query5 = session.createNativeQuery(hql5);
		List<Object[]> listEmpleadosProyecto = query5.getResultList();

		System.out.println("\n Tabla Número de empleados y proyectos por sede.");
		System.out.println("Emp" + " / " + "Proy" + " / " + "Sedes");
		for (Object[] i : listEmpleadosProyecto) {

			System.out.println(i[0] + " / " + i[1] + " / " + i[2]);
		}

		// El número de departamentos buscados por nombre.
		String hql6 = "Select  count(empleado.nom_emp) \r\n" + "from empleado \r\n" + "where nom_emp=\"Empleado: 1\";";
		Query query6 = session.createNativeQuery(hql6);
		List listEmpleadosPorNombre = query6.getResultList();
		Number numeroInt = (Number) listEmpleadosPorNombre.get(0);

		System.out.println("\n Tabla El número de departamentos buscados por nombre. 'Empleado: 1'");
		System.out.println(numeroInt.intValue());

		// El empleado con mayor sueldo.
		String hql7 = "Select empleado.nom_emp, MAX(empleado_datos_prof.sueldo_bruto_anual)\r\n" + "from empleado \r\n"
				+ "join empleado_datos_prof\r\n" + "on empleado.dni= empleado_datos_prof.dni";
		Query query7 = session.createNativeQuery(hql7);
		List<Object[]> listEmpleadosMayorSuelo = query7.getResultList();

		System.out.println("\n Tabla El empleado con mayor sueldo.");
		for (Object[] i : listEmpleadosMayorSuelo) {

			System.out.println(i[0] + " / " + i[1]);
		}

		// Query nativa para mostrar un empleado con un dni concreto.
		String hql8 = "Select empleado.nom_emp, empleado.dni\r\n" + "from empleado \r\n" + "where dni=\"02720111V\";";
		Query query8 = session.createNativeQuery(hql8);
		List<Object[]> listEmpleadosDNI = query8.getResultList();

		System.out.println("\n Tabla El empleado con mayor sueldo.");
		for (Object[] i : listEmpleadosDNI) {

			System.out.println(i[0] + " / " + i[1]);
		}

		// Query 1
		String hql9 = "Select empleado.nom_emp, empleado.dni, empleado_datos_prof.sueldo_bruto_anual\r\n"
				+ "from empleado \r\n" + "join empleado_datos_prof\r\n" + "on empleado.dni=empleado_datos_prof.dni\r\n"
				+ "where sueldo_bruto_anual>1203;";
		Query query9 = session.createNativeQuery(hql9);
		List<Object[]> list1 = query9.getResultList();

		System.out.println("\n Tabla Empleados con sueldo > 1203");
		for (Object[] i : list1) {

			System.out.println(i[0] + " / " + i[1] + " / " + i[2]);
		}

		// Query 2
		String hql10 = "Select empleado.nom_emp, empleado.dni, empleado_datos_prof.sueldo_bruto_anual\r\n"
				+ "from empleado \r\n" + "join empleado_datos_prof\r\n" + "on empleado.dni=empleado_datos_prof.dni\r\n"
				+ "where sueldo_bruto_anual<1203;";
		Query query10 = session.createNativeQuery(hql10);
		List<Object[]> list2 = query10.getResultList();

		System.out.println("\n Tabla Empleados con sueldo < 1203");
		for (Object[] i : list2) {

			System.out.println(i[0] + " / " + i[1] + " / " + i[2]);
		}

		t.commit();
		session.close();
	}
}
