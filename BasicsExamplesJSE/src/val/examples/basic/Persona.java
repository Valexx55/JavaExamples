package val.examples.basic;


import java.io.Serializable;

public class Persona implements Serializable, Comparable{
	
	private int edad;
	private String nombre;
	
	
	public Persona(String nombre, int edad) {
		this.edad = edad;
		this.nombre = nombre;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.nombre + " " + this.edad;
	}
	
	
	@Override
	public int compareTo(Object o) {
		Persona p_aux = (Persona)o;
		
		return this.edad-p_aux.edad;
	}	
	
	/**
	 * Comprueba si el objeto es de tipo persona
	 * @param obj
	 * @return un objeto de Persona si obj era de tipo Persona o null, si obj no era de tipo Persona
	 */
	private Persona esTipoPersona (Object obj)
	{
		Persona p = null;
		
		if (obj instanceof Persona) {
			 p = (Persona) obj;
		}
		
		return p;
		
	}
	
	private static boolean contienenLoMismo (Persona p1, Persona p2)
	{
		boolean contienen_lomismo = false;
		
		
		contienen_lomismo = (p1.nombre.equals(p2.nombre)&&(p1.edad==p2.edad));
		
		return contienen_lomismo;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean dev= false;
		Persona p = null;
		
		dev = (null!=obj)&&((obj == this)||((null!=(p=esTipoPersona(obj)))&&(contienenLoMismo(this, p))));
	
		return (dev);
	}
}
