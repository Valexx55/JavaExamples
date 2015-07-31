package curso.jee;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;
import javax.faces.event.ActionEvent;

@ManagedBean(name="beanMensaje")
@SessionScoped
public class BeanMensaje implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = -4499913333822818803L;

  private String remitente;
  private String mensaje;
  private Date fecha;
  private String sex;
  private String email;
  private String tipoMensaje;

  //getters y setters de las propiedades...  etc.
  // hay que añadirlos aquí...

  public BeanMensaje (){
	 this.tipoMensaje = "felicitacion";
  }
  
  public void validaEmail(FacesContext context, UIComponent toValidate, Object value) throws ValidatorException {
     String correo = (String) value;
     if( ! correo.toLowerCase().matches( "^[a-z0-9]+([_\\.-][a-z0-9]+)*@([a-z0-9]+([\\.-][a-z0-9]+)*)+\\.[a-z]{2,}" ) ) {
        FacesMessage message = new FacesMessage("La dirección de email, no es correcta");
        throw new ValidatorException(message);
     }
  }

  

  public String enviarMensaje() {
     FacesMessage mensajeResultado = new FacesMessage("El mensaje ha sido enviado");
     String salida = "resultado"; //Si queremos ir al inicio (mensaje.xhtml) hay que poner salida="mensaje"
     FacesContext.getCurrentInstance().addMessage(null, mensajeResultado);
     return salida;
  }

public String getRemitente() {
	return remitente;
}

public void setRemitente(String remitente) {
	this.remitente = remitente;
}

public String getMensaje() {
	return mensaje;
}

public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}

public Date getFecha() {
	return fecha;
}

public void setFecha(Date fecha) {
	this.fecha = fecha;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getTipoMensaje() {
	return tipoMensaje;
}

public void setTipoMensaje(String tipoMensaje) {
	this.tipoMensaje = tipoMensaje;
}
  
public String mostrar ()
{
	System.out.println("Remitente = " + remitente);
	System.out.println("Email = " + email);
	System.out.println("Sexo = " + sex);
	return "confirmar";
}
  
}