package val.examples.junit;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class ClaseTest {

	static Operaciones tester;
	
	@BeforeClass
	public static void iniciaClase()
	{
		tester = new Operaciones();
	}
	
	@AfterClass
	public static void finClase()
	{
		tester = null;
	}
	
	@Test
	public void testSuma() {
		assertEquals("5 MAS 3 = 8 ", 8, tester.suma(5, 3));
	}

	@Test	
	public void testMultiplicacion() {
		assertEquals("5 por  3 = 15 ", 15, tester.multiplicacion(5, 3));
	}

	@Test
	public void testDivision() {
		assertEquals("5 entre  3 = 1 ", 1, tester.division(5, 3));
	}

	@Test
	public void testResta() {
		assertEquals("5 menos  3 = 2 ", 2, tester.resta(5, 3));
	}

}