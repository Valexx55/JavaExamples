package val.examples.basic.regexp;

/**
 * 
 * 
 * @author Vale
 * 
 * 
 * La siguiente clase contiene un pequeño ejemplo del empleo de Expresiones regulares en Java
 * La expresiones regulares son un mecanismo potente que nos permite prototipar palabras, de forma abreviada.
 * Descrita una expresión regular, la clase String, provee de métodos que ayuda a operar fácilmente con las cadenas
 * que coinciden con la expresión regular.
 * 
 * Siendo cadena un String, puedo aplicar:
 * 
 *cadena.matches("regex")	Devuelve TRUE si cadena, es descrita totalmente por la expresión regular pasada
 *cadena.split("regex")	Me devuelve un array de subcadenas de cadena, usando la expresión regular como separador. "regex" no está incluída en el resultado
 *cadena.replaceFirst("regex"), "replacement") Sustituye la primera aparición de la expresión regular en cadena, con el replacement dado
 *cadena.replaceAll("regex"), "replacement") Sustituye todas las apariciones de la expresión regular, con el replacement dado
 */
public class ExpresionesRegulares {
	
	
	
	public static void main(String[] args) {
		
		String linea = "asfadfbjp349iu'***hola@madrid.org///0sdg99sdg";
		//Dada una línea como las del ejemplo
		String expresion_regular_mails = "[\\S\\s]*[\\*\\*\\*]{1}[\\S]+@[\\S]+/{3}[\\S\\s]*";
		//escribirmos una expresión regular que la define y su significado sería:
			//Cualquier caracter (S) o espacio en blanco (s), de O a N veces (*)
			//seguido de un conjunto {1} de 3 asteriscos \\*
			//seguido de cualquier caracter (S) de 1 a N veces (+)
			//seguido de una arroba (@) 1 vez - simplemente @ -
			//seguido de 3 barras /{3}
			//y seguido de O a N (*) caracteres (S) o espacios en blanco(s)
		
		String expresion_regular_mails2 = "[\\*\\*\\*]{1}[\\S]+@[\\S]+/{3}";
		//Ahora, escribmos una expresión regular que defina el patrón de aparición de un e-mail
			//3 asteriscos
			//seguido de cualquier caracter
			//terminado con 3 barras
		
	
		
		if (linea.matches(expresion_regular_mails))//¿Se ajusta linea al patrón descrito por la expresion_regular_mails?
		{
			System.out.println("La linea Sí contiene la expresión regular descrita");
		}
		else System.out.println("La linea No contiene la expresión regular descrita");
		
		String[] devolucion = linea.split(expresion_regular_mails2);//Troceame en subcadenas, la cadena linea, usando como separador la expresión regular dada
		
		if (devolucion != null)
		{
			for (int i = 0; i < devolucion.length; i++) {
				System.out.println("" + i + " = " +devolucion[i]);
				
			}
		}
		/**
		 * Al ejecutar el código, el operador split, nos devuelve las substrings de línea, eliminado la expresión regular
		 * que describe la aparición de un mail.
		 * 
		 * SE PIDE --> Construir una o más  expresiones regulares que hagan lo opuesto: es decir, que quite la información no relevante
		 * y extraiga los mails, de forma que el uso de split, nos de la lista de mails en un array de Strings
		 * 
		 * Una vez conseguido, aplicar al ejemplo anterior
		 */
		
	}

}
