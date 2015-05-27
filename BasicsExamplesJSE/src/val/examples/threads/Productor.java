package val.examples.threads;

public class Productor implements Runnable {
	
	private Cola cola_productor;
	
	public Productor (Cola c)
	{
		cola_productor = c;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		int i = 0;
		while (true)
		{
			cola_productor.almacenar(i);
			System.out.println("El productor almacena = " +i);
			i++;
		}
		
	}

}
