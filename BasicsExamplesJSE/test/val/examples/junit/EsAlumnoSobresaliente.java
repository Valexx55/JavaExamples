package val.examples.junit;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import val.examples.basic.Alumno;
import val.examples.basic.TipoNota;


public class EsAlumnoSobresaliente extends TypeSafeMatcher<Alumno>{

	
	TipoNota nota = null;
	
	//En este método, describo el resultado esperado de la comprobación
	@Override
	public void describeTo(Description descripcion) {
		descripcion.appendText("Alumno con " + TipoNota.SOBRESALIENTE);
		
	}
	
	//En este otro método, describo el resultado en caso de que la comprobación de falso
	@Override
	protected void describeMismatchSafely(Alumno item,
			Description mismatchDescription) {
		mismatchDescription.appendText( item.getNombre() +" obtuvo " + item.getNombre_nota() +" ");
	}

	@Override
	protected boolean matchesSafely(Alumno alumno) {
		boolean b_dev = false;
		//NOTA: ESTE ALUMNO, ES EL PRIMER PARÁMETRO DE LA LLAMADA
		//Assert.assertThat(alumno, (new EsAlumnoSobresaliente()));
		//Y DEL QUE VAMOS A COMPROBAR SU ESTADO
		
		this.nota = alumno.getNombre_nota();
		if (this.nota.equals(TipoNota.SOBRESALIENTE))
		{
			b_dev = true;
		}
		else
		{
			b_dev = false;
		}
		
		return b_dev;
	}
	
	//@Factory
	public static Matcher<Alumno> alumnoSobresaliente ()
	{
		return new EsAlumnoSobresaliente();
	}

}
