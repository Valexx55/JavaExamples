package val.examples.basic.hibernate.dao;

import org.hibernate.Session;

public interface InterfaceDaoHibernate<Entity, Clave> extends InterfaceCrudDao{

	
	Session getSession();
	void setSession(Session sesion);
	void setClass(Class clase);
}
