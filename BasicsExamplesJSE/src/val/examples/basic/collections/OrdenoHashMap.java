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
		
		TreeMap<Coche, Persona> tm = new TreeMap<Coche, Persona>();
		tm.putAll(hm);
		
		col_dev = new LinkedHashMap<Coche, Persona>();
		col_dev.putAll(tm);
		
		return col_dev;
		
	}
	
	
	public static Map<Coche, Persona> ordenaPorValor (HashMap<Coche, Persona> hm)
	{
		LinkedHashMap<Coche, Persona> col_dev = null;
		Persona p_aux = null;
		
		ArrayList<Persona> al_valores = new ArrayList<Persona>();
		ArrayList<Coche> al_claves = new ArrayList<Coche>();
		
		al_valores.addAll(hm.values());
		al_claves.addAll (hm.keySet());
		
		TreeSet<Persona> tm = new TreeSet<Persona>();
		tm.addAll(hm.values());
		
		al_valores.addAll(tm);
		
		Iterator<Persona> it = tm.iterator();
		col_dev = new LinkedHashMap<Coche, Persona>();
		
		while (it.hasNext())
		{
			p_aux = (it.next());
			col_dev.put(al_claves.get(al_valores.indexOf(p_aux)), p_aux);
		}
		
		
		return col_dev;
		
	}

}
