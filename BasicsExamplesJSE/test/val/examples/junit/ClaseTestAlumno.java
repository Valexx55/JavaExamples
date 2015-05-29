package val.examples.junit;
import org.junit.Assert;
import org.junit.Test;

import val.examples.basic.Alumno;
import val.examples.basic.exceptions.NotaException;

public class ClaseTestAlumno {
	
	@Test
	public void alumnoSobre ()
	{
		Alumno alumno;
		try {
			alumno = new Alumno("JuanJo", 39, 9);
			Assert.assertThat(alumno, (new EsAlumnoSobresaliente()));
		} catch (NotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
