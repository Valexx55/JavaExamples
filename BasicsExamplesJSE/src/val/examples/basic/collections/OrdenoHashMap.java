package val.examples.basic.collections;

import val.examples.basic.Coche;
import val.examples.basic.Persona;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;


public class OrdenoHashMap {
	
	public static Map<Coche, Persona> ordenaPorClave (HashMap<Coche, Persona> hm)
	{
		LinkedHashMap<Coche, Persona> col_dev = null;
		
		TreeMap<Coche, Persona> tm = new TreeMap<Coche, Persona>(); //me creo un árbol
		tm.putAll(hm);//él solito va a ordenar todos los valores
		
		col_dev = new LinkedHashMap<Coche, Persona>();//me creo un hashmap enlazado, que respeta el orden de inserción
		col_dev.putAll(tm);//y vuelco allí la colección, ya ordenada previamente por TreeMap
		
		return col_dev;
		
	}
	
	
	public static Map<Coche, Persona> ordenaPorValor (HashMap<Coche, Persona> hm)
	{
		LinkedHashMap<Coche, Persona> col_dev = null;
		Persona p_aux = null;
		
		ArrayList<Persona> al_valores = new ArrayList<Persona>();//en este array, guardaré los valores del hashmap
		ArrayList<Coche> al_claves = new ArrayList<Coche>();//y en este, las claves
		
		al_valores.addAll(hm.values());//despues de estas lineas, tengo dos arrays, uno con personas y otros con coches, 
		al_claves.addAll (hm.keySet());//pero lo importante, es que el orden en que se guardan, es igual que el original
		
		TreeSet<Persona> tm = new TreeSet<Persona>();//ahora me creo el TreeSet, 
		tm.addAll(hm.values());//que ordenará a las personas (values) por el orden natural
		
		
		col_dev = new LinkedHashMap<Coche, Persona>(); //iniciaizo la estructura de salida
		Iterator<Persona> it = tm.iterator();//y me dispongo a recorrer el árbol ordenado
		
		while (it.hasNext())
		{
			p_aux = (it.next());//Obteno la persona en curso ( la primera vez, sera la de menor edad)
			col_dev.put(al_claves.get(al_valores.indexOf(p_aux)), p_aux);//aquí está la clave: en la salida, pongo a esa persona, y para recoger su clave asociada, uso los arrays de claves y valores, donde habia guardado su correspondencia
			//en el indice (posicion), donde estuviera la persona, estara tambien la clave (en el otro array, pero en la misma posicion)
		}
		
		
		return col_dev;
		
	}

}
