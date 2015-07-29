package curso.jee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class HolaMundo {
	

	private String nombre;
	
	public HolaMundo()
	{
		nombre="Ignacio";
	}

	public String getNombre() {
		
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int longuitud()
	{
		return this.nombre.length();
	}

}
