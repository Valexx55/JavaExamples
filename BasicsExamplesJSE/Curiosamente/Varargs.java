
/**
 * Curioso,número de argumentos variable con notaciónn " . . . " --> número de parámetros variable, 
 * desde java 5 yu yo sin saberlo
 * 
 * @author Vale
 *
 */

public class Varargs {

	public void hola (Integer i, String ... a)
	{
		
	}
	
	public static void main(String[] args) {
		Varargs h = new Varargs();
		h.hola(new Integer (8), "a", "b", "c", "d");
	}
}
