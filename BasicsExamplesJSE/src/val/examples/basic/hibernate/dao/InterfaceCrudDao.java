package val.examples.basic.hibernate.dao;


public interface InterfaceCrudDao{
	
	Object create (Object objeto_dto);
	Object read (Object clave);
	void update (Object objeto_dto);
	void delete (Object objeto_dto);

}
