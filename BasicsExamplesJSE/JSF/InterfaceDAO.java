package jsf.dao;

import java.util.List;

public interface InterfaceDAO {
	
	Object create (Object objeto_dto);
	Object read (Object clave);
	void update (Object objeto_dto);
	void delete (Object objeto_dto);

}
