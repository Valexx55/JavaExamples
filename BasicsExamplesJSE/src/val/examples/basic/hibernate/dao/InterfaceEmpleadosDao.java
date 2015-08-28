package val.examples.basic.hibernate.dao;

import java.util.List;

import org.hibernate.metamodel.domain.Entity;

import val.examples.basic.hibernate.dao.dominio.Employees;

public interface InterfaceEmpleadosDao extends InterfaceCrudDao {

	List<Employees> findAll();
	
}
