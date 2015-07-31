package jsf.dao;

import java.util.List;

import jsf.entidades.Departments;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DepartmentsDAO extends GenericDAO implements InterfaceDepartamentsDAO{
	

	

	@Override
	public Object create(Object objeto_dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object read(Object clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Object objeto_dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object objeto_dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Departments> list ()
	{
		List<Departments> lista_departamentos = null;
		
		lista_departamentos = sesion.createSQLQuery("Select * from Departments").addEntity(Departments.class).list();
		
		return lista_departamentos;
	}
}
