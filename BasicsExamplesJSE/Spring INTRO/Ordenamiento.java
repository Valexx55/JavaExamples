package org.apache.struts.edit.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Ordenamiento implements Proceso
{
    public Object ejecuta()
    {
        List< Integer> listaEnteros = new ArrayList<Integer>();

        listaEnteros.add(9);
        listaEnteros.add(3);
        listaEnteros.add(1);
        listaEnteros.add(6);
        listaEnteros.add(5);
        listaEnteros.add(10);

        Collections.sort(listaEnteros);

        return listaEnteros;
    }
}