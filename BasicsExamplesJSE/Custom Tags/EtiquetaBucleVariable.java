package web.curso;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class EtiquetaBucleVariable extends SimpleTagSupport{
	
	
	private int num;
	
	
	
	@Override
	public void doTag() throws JspException, IOException {
		
		for (int i=0; i<num; i++) {
            getJspContext().setAttribute("count", String.valueOf( i + 1 ) );
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
