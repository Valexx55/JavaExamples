package org.apache.struts.edit.action;

public class Calculo implements Proceso
{
    public Object ejecuta()
    {
        return (int)(Math.random()*100.0);
    }
}