package val.examples.basic.hibernate.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.metamodel.domain.Entity;

import val.examples.basic.hibernate.dao.dominio.ClaseDto;

public class GenericDao implements InterfaceDaoHibernate{

	private Session sesion;
	private Class clase_dto;
	
	@Override
	public Session getSession() {
		return this.sesion;
	}

	@Override
	public void setSession(Session sesion) {
		this.sesion = sesion;
		
	}
	@Override
	public Object create(Object objeto_dto) {
		Object clave = null;
		clave = getSession().save(objeto_dto);
		return clave;
	}

	@Override
	public Object read(Object clave) {
		Object objeto_recuperado = null;
		objeto_recuperado =  getSession().get(clase_dto, (Serializable) clave);
		return objeto_recuperado;
	}

	@Override
	public void update(Object objeto_dto) {
		getSession().update(objeto_dto);
	}

	@Override
	public void delete(Object objeto_dto) {
		getSession().delete(objeto_dto);
	}

	@Override
	public void setClass(Class clase) {
		this.clase_dto = clase;
		
	}
}
