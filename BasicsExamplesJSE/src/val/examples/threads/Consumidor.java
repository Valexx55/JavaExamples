package val.examples.threads;

public class Consumidor implements Runnable {
	
	private Cola cola_consumidor;
	private int nconsumidor;
	
	public Consumidor (Cola c, int nconsu)
	{
		cola_consumidor = c;
		nconsumidor = nconsu;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i = 0;
		while (true)
		{
			i = cola_consumidor.extraer();
			System.out.println("El consumidor "+  nconsumidor  + " extare = " +i);
		}
		
	}
}
