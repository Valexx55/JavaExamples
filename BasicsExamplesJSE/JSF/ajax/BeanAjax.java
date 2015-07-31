package curso.jee;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class BeanAjax {

	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getSaludo ()
	{
		return this.nombre;
	}
	
	public void modifica ()
	{
		System.out.println("Evento disparado");
		this.nombre = "Hola " + this.nombre;
	}
}
