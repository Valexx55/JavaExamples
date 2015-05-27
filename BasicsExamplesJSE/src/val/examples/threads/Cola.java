package val.examples.threads;

public class Cola {
	
	private int [] datos;
	private int sgte_entrar, sgte_salir, ocupados, tamanio;
	
	public Cola (int tamanio)
	{
		this.datos = new int[tamanio];
		this.tamanio = tamanio;
		ocupados = 0;
		sgte_entrar = 1;
		sgte_salir = 1;
		
	}
	
	
	public synchronized void almacenar (int x)
	{
		try {
			while (ocupados == tamanio) 
				{
				wait();
				}
			datos [sgte_entrar] = x;
			sgte_entrar = (sgte_entrar+1) % tamanio;
			ocupados++;
			notify();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public synchronized int extraer ()
	{
		int x=0;;
		try {
			while (ocupados == 0) 
				{
				wait();
				}
			x = datos [sgte_salir];
			sgte_salir = (sgte_salir+1) % tamanio;
			ocupados--;
			notify();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return x;
	}

}
