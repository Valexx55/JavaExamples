package jsf.services;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import jsf.dao.DepartmentsDAO;
import jsf.dao.GenericDAO;
import jsf.dao.InterfaceDAO;
import jsf.dao.InterfaceDepartamentsDAO;
import jsf.dao.SesionManager;
import jsf.entidades.Departments;

@ManagedBean
@SessionScoped
public class DepartmentServices implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7357986089725740122L;
	InterfaceDAO departmentDAO;
	
	public DepartmentServices()
	{
		departmentDAO = new DepartmentsDAO();
	}
	
	public List<Departments> obtenerListaDepartamentos ()
	{
		List<Departments> lista_departamentos = null;
		Session sesion = null;
		Transaction tx = null;
		
			try 
				{
					sesion = SesionManager.obtenerSesionNueva();
					((GenericDAO)departmentDAO).setSesion(sesion);
					tx = sesion.beginTransaction();
					lista_departamentos = ((InterfaceDepartamentsDAO)departmentDAO).list();
					tx.commit();
				} 
			catch (Exception e) 
				{
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
		
			
		return lista_departamentos;
	}

}
