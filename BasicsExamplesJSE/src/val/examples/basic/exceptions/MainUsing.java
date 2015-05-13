package val.examples.basic.exceptions;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;



/**
 * Desde la versión 7 de Java, se ha incorporado esta posibilidad, llamada
 * Manejo automático de recursos  
 * o try with resources statement
 * 
 * Consiste en que a continuación del try, puedo incluir una serie de sentencias
 * entre paréntesis, donde declaro recursos, que automáticamente serán liberados
 * al salir del try
 * 
 * Los recursos (objetos) referidos en la sección, deben implementar la interfaz
 * java.lang.AutoCloseable
 * 
 * 
 * @author Vale
 *
 */
public class MainUsing {

		
	public static void main(String[] args) throws Throwable {
		
		String linea = null;
		
		try(BufferedReader br = new BufferedReader(new FileReader("fichero.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("nuevo.txt"))){
			
			linea = br.readLine();
			System.out.println(linea);
			
			bw.write(linea);
			
		}
	}
}
