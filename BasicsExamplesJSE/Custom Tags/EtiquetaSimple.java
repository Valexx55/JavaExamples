package web.curso;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaSimple extends SimpleTagSupport{
	
	private String nombre;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		//sSystem.out.println(getJspBody().toString());
		getJspContext().getOut().println("llamando a Hola mundo!");
		if (null!=nombre)
		{
			getJspContext().getOut().println("Llama : " + nombre);
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
