package jsf.services;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jsf.dao.DepartmentsDAO;
import jsf.dao.EmpleadoDAO;
import jsf.dao.GenericDAO;
import jsf.dao.InterfaceDAO;
import jsf.dao.InterfaceDepartamentsDAO;
import jsf.dao.InterfaceEmpleadoDAO;
import jsf.dao.SesionManager;
import jsf.entidades.Departments;
import jsf.entidades.Employees;

@ManagedBean
@RequestScoped
public class EmpleadoServices {
	
	InterfaceDAO empleadoDAO;
	
	public EmpleadoServices()
	{
		empleadoDAO = new EmpleadoDAO();
	}
	
	public List<Employees> obtenerListaEmpleados (String id_dpto)
	{
		List<Employees> lista_empleados = null;
		Session sesion = null;
		Transaction tx = null;
		
			try 
				{
					sesion = SesionManager.obtenerSesionNueva();
					((GenericDAO)empleadoDAO).setSesion(sesion);
					tx = sesion.beginTransaction();
					lista_empleados = ((InterfaceEmpleadoDAO)empleadoDAO).list(id_dpto);
					tx.commit();
				} 
			catch (Exception e) 
				{
					e.printStackTrace();
					tx.rollback();
				} 
			finally 
				{
					if (null!=sesion)
						try 
							{
								sesion.close();
							} 
						catch (Exception e2) 
							{
								e2.printStackTrace();
							}
				}
		
			
		return lista_empleados;
	}

}
