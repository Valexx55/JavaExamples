package val.examples.threads;

public class MainProductorConsumidor {
	
	
	
	public static void main(String[] args) {
		
		Cola buffer;
		Productor p;
		Consumidor c[];
		
		buffer = new Cola(50);
		p = new Productor(buffer);
		c = new Consumidor[3];
		for (int i = 0; i < c.length; i++) {
			c[i] = new Consumidor(buffer, i);
			
		}
		
		Thread hiloP = new Thread(p);
		hiloP.start();
		
		
		Thread hiloc = null;
		for (int i = 0; i < c.length; i++) {
			
			hiloc = new Thread (c[i]);
			hiloc.start();
		}
		
		
	}
	
	
	

}
