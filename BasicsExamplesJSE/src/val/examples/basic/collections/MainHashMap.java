package val.examples.basic.collections;

import val.examples.basic.Coche;
import val.examples.basic.Persona;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainHashMap {
	
	
public static void main(String[] args) {
		
		Persona p1 = new Persona("Giovani", 23);
		Persona p2 = new Persona("Iñaki", 24);
		Persona p3 = new Persona("Joel", 20);
		Persona p4 = new Persona("Ruth", 17);
		Persona p5 = new Persona("Francesco", 30);
		
		Coche c1 = new Coche("3365MLZ", Coche.TipoMarca.FORD);
		Coche c2 = new Coche("2598PQS", Coche.TipoMarca.MERCEDES);
		Coche c3 = new Coche("4546VZR", Coche.TipoMarca.FIAT);
		Coche c4 = new Coche("9879QAS", Coche.TipoMarca.KIA);
		Coche c5 = new Coche("5672LMN", Coche.TipoMarca.NISSAN);
		
		HashMap<Coche, Persona> mapa_personas_coche = new HashMap<Coche, Persona>();
		
		mapa_personas_coche.put(c1, p1);
		mapa_personas_coche.put(c2, p2);
		mapa_personas_coche.put(c3, p3);
		mapa_personas_coche.put(c4, p4);
		mapa_personas_coche.put(c5, p5);
		
		System.out.println("HashMap lo inserta, como Dios le dio a entender...");
		System.out.println(mapa_personas_coche + "\n");
		
		
		LinkedHashMap<Coche, Persona> mapa_personas_coche_ordenado_por_clave = (LinkedHashMap<Coche, Persona>) OrdenoHashMap.ordenaPorClave(mapa_personas_coche);
		
		System.out.println("Ahora lo tenemos ordenado por el orden natural de clave (matrícula del coche) ;)");
		System.out.println(mapa_personas_coche_ordenado_por_clave + "\n");
		
		
		LinkedHashMap<Coche, Persona> mapa_personas_coche_ordenado_por_valor = (LinkedHashMap<Coche, Persona>) OrdenoHashMap.ordenaPorValor(mapa_personas_coche);
		
		System.out.println("Ahora lo tenemos ordenado por el orden natural de valor (edad de la persona) ;)");
		System.out.println(mapa_personas_coche_ordenado_por_valor);
		
		
		LinkedHashMap<Coche, Persona> mapa_personas_coche_ordenado_por_valor2 = (LinkedHashMap<Coche, Persona>) OrdenoHashMap.ordenaPorValor2(mapa_personas_coche);
		
		System.out.println("Ahora lo tenemos ordenado por el orden natural de valor (edad de la persona) ;)");
		System.out.println(mapa_personas_coche_ordenado_por_valor2);
		
		
	}

}
