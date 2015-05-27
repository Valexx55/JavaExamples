package val.examples.threads;

public class PrincipalEntradas {
	
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente ("Juan");
		Cliente cliente2 = new Cliente ("Pedro");
		Cliente cliente3 = new Cliente ("Marta");
		
		
		Thread hiloCliente1 = new Thread(cliente1);
		Thread hiloCliente2 = new Thread(cliente2);
		Thread hiloCliente3 = new Thread(cliente3);
		
		hiloCliente1.start();
		hiloCliente2.start();
		hiloCliente3.start();
		
	}

}
