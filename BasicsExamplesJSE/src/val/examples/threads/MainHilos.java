package val.examples.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainHilos {

	public static void main(String[] args) {
		Hilos h1 = new Hilos("Conejo");
		Hilos h2 = new Hilos("Tortuga");
		Hilos h3 = new Hilos("Zorro");
		
		h2.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		
		System.out.println("Y yo desde el main escribo algo");
		/*List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<>();
		
		
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(2);
		list.add(9);
		list.add(8);
		list.add(10);
		
		System.out.println(list.toString());
		Collections.sort(list);
		System.out.println(list.toString());

		list2.addAll(list);
		System.out.println(list2.toString());
*/
		
	}
}
