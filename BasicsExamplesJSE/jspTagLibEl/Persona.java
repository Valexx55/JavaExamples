package org.microforum.cursojava.jee;


public class Persona {
	
	private int edad;
	private String nombre;
	private Perro perro;
	
	
	public Persona() {
		
	}
	
	public Perro getPerro()
	{
		return perro;
	}
	
	public void setPerro(Perro perro)
	{
		this.perro = perro;
	}
	
	public Persona(int edad, String nombre, Perro perro) {
		this.edad = edad;
		this.nombre = nombre;
		this.perro = perro;
	}
	
	public Persona(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
		this.perro = perro;
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

	

}
