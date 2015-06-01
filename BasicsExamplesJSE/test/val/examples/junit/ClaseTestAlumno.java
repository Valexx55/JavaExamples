package val.examples.junit;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

import val.examples.basic.Alumno;
import val.examples.basic.exceptions.NotaException;
import static val.examples.junit.EsAlumnoSobresaliente.*;
import static org.hamcrest.core.IsNot.*;

public class ClaseTestAlumno {
	
	@Test
	public void alumnoSobre ()
	{
		Alumno alumno;
		try {
			alumno = new Alumno("JuanJo", 39, 8); //Para el 9, estoy esperadno que su nota sea Sobresaliente
			//Assert.assertThat(alumno, (new EsAlumnoSobresaliente()));
			Assert.assertThat(alumno, not(alumnoSobresaliente()));
			//alumno, sería el objeto actual, sobre el que voy a realizar la comprobación, del segundo parámetro
		} catch (NotaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
