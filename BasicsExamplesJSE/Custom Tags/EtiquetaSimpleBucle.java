package web.curso;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaSimpleBucle extends SimpleTagSupport{
	
	private int num;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		//sSystem.out.println(getJspBody().toString());
		StringWriter bodyamodificar = new StringWriter();
		getJspBody().invoke(bodyamodificar); //relleno la variable para poder modificarla
		bodyamodificar = bodyamodificar.append("- MODIFICADO");
		getJspContext().getOut().println("El body es = "+bodyamodificar +" ese es el body");
		
		for (int i = 0; i < num; i++) {
			
			getJspBody().invoke(null);
			
		}
		
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}

}
