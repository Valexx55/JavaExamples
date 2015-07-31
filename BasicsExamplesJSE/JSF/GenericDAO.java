package jsf.dao;

import org.hibernate.Session;

public class GenericDAO {
	
	Session sesion;

	public Session getSesion() {
		return sesion;
	}

	public void setSesion(Session sesion) {
		this.sesion = sesion;
	}
	
	

}
