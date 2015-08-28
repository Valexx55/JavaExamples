package val.examples.basic.hibernate.dao.services;



import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.metamodel.domain.Entity;

import val.examples.basic.hibernate.dao.EmployeeDao;
import val.examples.basic.hibernate.dao.InterfaceEmpleadosDao;
import val.examples.basic.hibernate.dao.SesionManager;
import val.examples.basic.hibernate.dao.dominio.ClaseDto;
import val.examples.basic.hibernate.dao.dominio.Employees;

public class EmployeesServices {
	
	
	private static final float PORCENTAJE_INCREMENTO_SALARIAL = 20;
	
	private InterfaceEmpleadosDao empleado_dao;
	
	private Logger log = Logger.getLogger("mylog");
	
	
	public EmployeesServices ()
	{
		empleado_dao = new EmployeeDao();;
	}
	
	
	private void actualizaSalario (List<Employees> lista_empleados)
	{
		for (Employees empleado:lista_empleados)
		{
			empleado.setSalary(empleado.getSalary().add(
							   empleado.getSalary().multiply(new BigDecimal(PORCENTAJE_INCREMENTO_SALARIAL/100))));
		}
	}
	
	public boolean incrementarSalario ()
	{
		boolean bd = false;
		List<Employees> lista_empleados = null;
		Session sesion = null;
		Transaction transaccion = null;
		
		log.debug("Inicio el servicio de incrementar salario");
		
		try
		{
			sesion = SesionManager.obtenerSesionNueva();
			transaccion = sesion.beginTransaction();
			((EmployeeDao) empleado_dao).setSession(sesion);
			
			log.debug("Llamo a recuperar empleados");
			lista_empleados = empleado_dao.findAll();
			log.debug("Llamo a actualizar salario");
			actualizaSalario(lista_empleados);
			log.debug("Commit");
			transaccion.commit();
			bd=true;
			
		} catch (Exception e)
		{
			e.printStackTrace();
			log.error(e);
			transaccion.rollback();
		}
		finally
		{
			SesionManager.cerrarSession(sesion);
		}
		
	
		return bd;
	}
	
	public void leerEmpleado (int n_empleado)
	{
		boolean bd = false;
		Employees empleado = null;
		Session sesion = null;
		Transaction transaccion = null;
		
		log.debug("Inicio el servicio de incrementar salario");
		
		try
		{
			sesion = SesionManager.obtenerSesionNueva();
			transaccion = sesion.beginTransaction();
			((EmployeeDao) empleado_dao).setSession(sesion);
			((EmployeeDao) empleado_dao).setClass(Employees.class);
			log.debug("Llamo a recupera empleado");
			empleado = (Employees) empleado_dao.read(n_empleado);
			System.out.println(empleado.toString());
			transaccion.commit();
			bd=true;
			
		} catch (Exception e)
		{
			e.printStackTrace();
			log.error(e);
			transaccion.rollback();
		}
		finally
		{
			SesionManager.cerrarSession(sesion);
		}
		
	}

}
