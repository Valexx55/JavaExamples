package val.examples.basic.regexp;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class ClaseLeeMails {
	
	private static final String INICIO_MAIL = "***";
	private static final String FIN_MAIL = "///";
	
	private static String procesarLinea (String linea_actual)
	{
		String mails_de_linea_actual = "";
		
		//TODO este es el método más difícil...recibiré una línea y tendré que extraer de ella todos correos
		//e irlos concatenando en un String de salida
		//Pista---> Sabemos la longuitud de la linea, sabemos que un Email viene encerrado entre símbolos especiales...
		// Paciencia y a pensar como si lo estuvieras cogiendo con las manos...ve declarando todas las condiciones, variables y bucles que necesites!!!
		//Poco a poco...El lápiz y papel, ayudan siempre un montón!
		
		int longuitud = linea_actual.length();
		int posicion_actual = 0;
		int empieza, acaba = 0;
		String email = "";
		
		while (posicion_actual<longuitud)
		{
			empieza = linea_actual.indexOf(INICIO_MAIL, posicion_actual);
			if (empieza != -1)
			{
				acaba = linea_actual.indexOf(FIN_MAIL, empieza+3);
				email = linea_actual.substring(empieza+3, acaba+1);
				mails_de_linea_actual = mails_de_linea_actual + email;
				posicion_actual = acaba;
			}
			else {
					posicion_actual=longuitud;
				 }
		}
			
		return mails_de_linea_actual;
	}
	
	
	/**
	 * Este métdo ya viene hecho!
	 * En él, recorro el fichero y devuelvo un String, que estará compuesto por todos
	 * los mails que aparecen en el fichero separados por /
	 * 
	 * Por ejemplo, para este fichero: 
	 * 
	 * vxscavsdfgv***susana@kelly.org///asv afsvasczx xcvasdf'ow048t09q38r`0gf9uq nw9eru`	wefu8ioW´`EO
	 * qer`kgq`pegiq3'5oyq'3'oaae'5oy'q35oy'q35oygadkfbbASKLF,B`R,BEPÈD,FVA´PSF,DVÑ,AFS`BKAFSÇKBAFDÑS
     * AOBRJ KQG'¡3KGP`KVASF***francesco@hp.es///BLALÑDFBMMA
     * 
     * debería devolver un String que fuera susana@kelly.org/francesco@hp.es
     * 
     * Para simplificar el proceso, cada línea obtenida del fichero, la voy
     * a procesar aparte, en el método procesarLinea; que se va a encargar sólo 
     * de procesar cada línea. De este modo, sigo una máxima en programación:
     * Si una cosa es muy larga o complicada....LA DIVIDO! 
     * "DIVIDE Y VENCERÁS"
	 * 
	 * @param br
	 * @return
	 * @throws IOException
	 */
	private static String obtenerEmails (BufferedReader br) throws IOException
	{
		String lista_mails = "";
		String linea = null;
	
		boolean final_fichero = false;
		
		while (!final_fichero)
		{
			linea = br.readLine();
			if (linea == null)
			{
				final_fichero = true;
			} else 
				{
					lista_mails = lista_mails + procesarLinea (linea);
				
				}
		}
		
		return lista_mails;
		
	}
	
	private static BufferedReader abrirYPrepararFichero (String nombre) throws FileNotFoundException
	{
		BufferedReader br = null;
		
		br = new BufferedReader(new FileReader(nombre));
		
		return br;
	}
	
	private static String [] hacerArrayDeMails (String lista_mails)
	{
		String [] array_mails = null;
		
		array_mails = lista_mails.split("/");
		
		return array_mails;
	}
	
	private static void mostrarMails (String [] lista_mails)
	{
		for (int i = 0; i < lista_mails.length; i++) {
			System.out.println("Mail " + i + " = " + lista_mails[i]);
		}
	}
	
	private static void ordenarMails (String [] array_mails)
	{
		Arrays.sort(array_mails); 
	}
	
	private static void cerrarFichero (BufferedReader br) throws IOException
	{
		br.close();
	}
	

	/**
	 * NOTA Todos los métodos de la clase son static, para facilitar su uso sin tener
	 * que instanciar un Objeto. Si no fueran static, con declarar un objeto de la clase
	 * ya podría llamar a los métodos, por ejempleo
	 * 	
	 * 	ClaseLeeMails clm = new ClaseLeeMails();
	 *  clm.ababrirYPrepararFichero ... etc 
	 *  
	 *  OK????
	 * 	 
	 * */
	
	public static void main(String[] args) throws IOException {
		
		String nombre = "fichero.txt";//el nombre del fichero de entrada
		String lista_mails = null; //aquí guardaré los mails, separados por la el símbolo /
		String [] array_mails = null; //aquí guardaer los mails, cada uno en su posición!
		BufferedReader br = null; // Objeto para leer un fichero de texto por líneas!
		
				
		br = abrirYPrepararFichero(nombre);
		lista_mails = obtenerEmails(br);
		cerrarFichero (br);
		array_mails =  hacerArrayDeMails(lista_mails);
		ordenarMails (array_mails); // Este método es opcional, aunque luego veremos que es muy fácil de hacer!
		mostrarMails(array_mails);
		
	}
	
}
