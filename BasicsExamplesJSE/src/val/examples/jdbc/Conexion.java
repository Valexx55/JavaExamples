package val.examples.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * Si queréis que adaptar esta clase a vuestra práctica, sólo deberíais modificar
 * el fichero de propiedades ajustándolo a vuestras necesidades (el de log y el de db
 * 
 * Ya no es Singleton, pero incluye la sección de código static, para que tengáis un ejemplo
 * de otra cosita nueva ;)
 * 
 * @date 03-06-2015
 * @author Vale
 *
 */
public class Conexion {

	
	private static final String RUTA_PROPERTIES = "db.properties";
	private static Logger log = Logger.getLogger("mylog");
	private static String cadena_conexion; 
	private static String usuario;
	private static String contrasenia;
	
	static{
		//el bloque de código encerrado en esta llaves static 
		//sólo se ejecutará una vez; la primera que es invocada esta clase Conexion!!!
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(RUTA_PROPERTIES));
			String s_driver = properties.getProperty("driver");
			cadena_conexion = properties.getProperty("cadena_conexion");
			usuario = properties.getProperty("user");
			contrasenia = properties.getProperty("password");
			Class.forName(s_driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Fichero de properties no encontrado");
		} catch (ClassNotFoundException e) {
			log.error("Error al intentar conectar a la base de datos: driver no encontrado");
		}
		
	}
	
	
	public static Connection obtenerConexion () throws SQLException
	{
		//bug corregido --> ahora devuelvo una nueva conexión cada vez que me lo piden
		return DriverManager.getConnection(cadena_conexion, usuario, contrasenia);
	}
	
	public static void liberarRecursos (Connection conn, Statement stmt, ResultSet rset)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
	}
	
	//nuevo método, sobrecarga del anterior, cuando necesitáis liberar recursos, después
	//de ejecutar una instrucción que NO es un SELECT ;)
	public static void liberarRecursos (Connection conn, Statement stmt)
	{
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
	}
}
