package val.examples.basic.recursividad;



import java.io.File;


/**
 * 
 * @author Valentinik
 * 
 * Ejemplo de pequeña clase Main que recorre un arbol de directorios de forma recursiva
 *
 */
public class RecorrerSF {
	
	/**
	 * 
	 * El algoritmo principal es:
	 * 
	 * imprimo la ruta del fichero
	 * si es un directorio
	 * 	obtengo la lista de subarchivos
	 * 	y para cada archivo, llamo
	 * 
	 * @param fname es el parámetro que contiene el nombre del fichero o de la ruta actual
	 * @param cadspace usado para formatear la salida y que se observe la jerarquía de directorios
	 */
	private void mostarRuta (String fname, String cadspace)
	{
		File fichero = null;
		String [] listado = null;
		
		fichero = new File (fname); //supongo que el directorio archivo existe!! 
		System.out.println(cadspace+fichero.getName());//y sea directorio o fichero, imprimo: caso base
	
		if (fichero.isDirectory()) //si es un directorio, (caso recursivo)
		{
			listado = fichero.list(); //obtengo la lista
			for (String cad : listado) //y para cada subarchivo, llamo
			{
				mostarRuta(fname+'\\'+cad, cadspace+" "); //concateno el archivo o carpeta escapando el backslash y le sumo un espacio al prefijo, para incrementar el nivel
			}
		}
		
		
	}
	public static void main(String[] args) {
		
		RecorrerSF recorrerSF = new RecorrerSF();
		
		recorrerSF.mostarRuta(".", "");
		
	}

}
