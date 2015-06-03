package val.examples.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Conexion {

	
	private static Conexion conexion = new Conexion();
	private Connection connection;
	private final String RUTA_PROPERTIES = "db.properties";
	private Logger log = Logger.getLogger("mylog");
	
	
	
	private Conexion () {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(RUTA_PROPERTIES));
			String s_driver = properties.getProperty("driver");
			String cadena_conexion = properties.getProperty("cadena_conexion");
			String usuario = properties.getProperty("user");
			String contrasenia = properties.getProperty("password");
			Class.forName(s_driver);
			DriverManager.registerDriver((Driver) Class.forName(s_driver).newInstance());
			this.connection = DriverManager.getConnection(cadena_conexion, usuario, contrasenia);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Error al intentar conectar a la base de datos");
		} catch (ClassNotFoundException e) {
			log.error("Error al intentar conectar a la base de datos: driver no encontrado");
		} catch (InstantiationException e) {
			log.error("Error al instanciar el driver");
		} catch (IllegalAccessException e) {
			log.error("Error al instanciar el driver");
		}
		
				
	}
	
	public static Connection obtenerConexion ()
	{
		return conexion.connection;
	}
	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
}
