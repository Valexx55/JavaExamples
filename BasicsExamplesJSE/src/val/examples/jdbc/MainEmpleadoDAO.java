package val.examples.jdbc;

import java.sql.SQLException;
import java.util.List;

public class MainEmpleadoDAO {
	
	
	public static void main(String[] args) {
		 try {
			 
			List<EmpleadoDTO> lista_empleados = EmpleadoDAO.obtenerTodos();
			System.out.println(lista_empleados);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al recuperar la lista de empleados de la base de datos");
			
		}
	}

}
