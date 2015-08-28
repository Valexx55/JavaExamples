package val.examples.basic.hibernate.dao;

import java.util.List;

import val.examples.basic.hibernate.dao.dominio.ClaseDto;
import val.examples.basic.hibernate.dao.dominio.Employees;

public class EmployeeDao extends GenericDao implements InterfaceEmpleadosDao{

	
	@Override
	public List<Employees> findAll() {
		List<Employees> lista_empleados = null;
		lista_empleados = getSession().createSQLQuery(Instrucciones.CONSULTA_TODOS_EMPLEADOS).addEntity(Employees.class).list();
		return lista_empleados;
	}

}
