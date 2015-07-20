package org.apache.struts.edit.action;

public class Concatenacion implements Proceso
{
    public Object ejecuta()
    {
        return new StringBuilder().append("Hola ").append(" mundo");
    }
}