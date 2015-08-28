package val.examples.basic.hibernate.dao.services;

import val.examples.basic.hibernate.dao.SesionManager;

public class MainHibernateDao {

	
	public static void main(String[] args) {
		EmployeesServices empleado_servicio = new EmployeesServices();
		
		empleado_servicio.leerEmpleado(100);
		SesionManager.cerrarFactory();
	}
}
