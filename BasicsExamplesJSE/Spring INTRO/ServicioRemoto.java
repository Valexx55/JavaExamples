package org.apache.struts.edit.action;

import com.opensymphony.xwork2.ActionSupport;

public class ServicioRemoto extends ActionSupport
{
    private Proceso proceso;
    private String resultado;
    
    public ServicioRemoto ()
    {
    }

    public ServicioRemoto(Proceso proceso)
    {
        this.proceso = proceso;
    }
    
    
    public String getResultado ()
    {
    	return resultado;
    }
    
    public String execute()
    {
    	resultado = proceso.ejecuta().toString();
    	return SUCCESS;
    }
}