package web.curso;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaClassic extends BodyTagSupport{
	
	private int num;
	private String idcountry;
	
	private int nveces = 0;
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("Estoy al inicio de la etiqueta");
		System.out.println("Id country = " +idcountry);
		//return EVAL_BODY_INCLUDE; //le digo que evalue el cuerpo!
		return EVAL_BODY_BUFFERED;//con esto llamría a dInitBOdy, por si tengo que hacer un preproceso antes de que el cuerpo sea evaluado!
	}
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("Estoy al final de la etiqueta, le dejo que siga");
		return EVAL_PAGE;
	}
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		int dval = 0;
		System.out.println("Ya se ha evaluado al cuerpo");
		nveces++;
		
		String evaluado = getBodyContent().getString();
		try {
			getBodyContent().getEnclosingWriter().println(evaluado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nveces>2)
			dval = EVAL_PAGE;
		else dval = EVAL_BODY_AGAIN;
		
		
		return dval;
	}
	@Override
	public void doInitBody() throws JspException {
		// TODO Auto-generated method stub
		System.out.println("Me han invocado desde dST()");
	}
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}
	public String getIdcountry() {
		return idcountry;
	}
	public void setIdcountry(String idcountry) {
		this.idcountry = idcountry;
	}


}
