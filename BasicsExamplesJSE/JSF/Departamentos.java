package curso.jee;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct; //las clases anotadas con esta ruta (annotation), son anotaciones gestionadas por las propias librerias del Contenedor Tomcat
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean; //las clases anotadas con esta ruta, (faces.bean) son anotaciones gestionadas por las propias librerias de JSF
import javax.faces.bean.ManagedProperty;//NO MEZCLAR, ojo
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import jsf.entidades.Departments;
import jsf.services.DepartmentServices;

@ManagedBean
@SessionScoped
public class Departamentos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5984900623587893508L;

	@ManagedProperty (value = "#{departmentServices}")
	private DepartmentServices departmentServices;
	
	private List<Departments> listaDepartamentos;
	
	private String selected;
	
	
	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public Departamentos() {
	}
	
	@PostConstruct
	public void init ()
	{
		System.out.println("El contenedor me ha instanciado");
		listaDepartamentos = departmentServices.obtenerListaDepartamentos(); //departamentServices es ya un objeto instanciado, gracias a que indiqué que era una @ManagedProperty (y a su vez, un managed bean)
	}

	@PreDestroy
	public void destroy ()
	{
		System.out.println("El contenedor me elimina");
	}

	public DepartmentServices getDepartmentServices() {
		return departmentServices;
	}

	public void setDepartmentServices(DepartmentServices servicioDepartamento) {
		this.departmentServices = servicioDepartamento;
	}

	public List<Departments> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departments> lista_departamentos) {
		this.listaDepartamentos = lista_departamentos;
	}
	
	public String actionEmpleados ()
	{
		//FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", selected); //esto también funcionaría ;)
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		req.setAttribute("id", selected);
		return "empleados";
	}
	
}
