package jsf.dao;

import java.util.List;

import jsf.entidades.Departments;
import jsf.entidades.Employees;

public interface InterfaceEmpleadoDAO extends InterfaceDAO {
	
	List<Employees> list (String id_departamento);
	
	

}
