package val.examples.basic.hibernate.transitivity;

import java.math.BigDecimal;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import val.examples.basic.hibernate.dao.dominio.Countries;
import val.examples.basic.hibernate.dao.dominio.Regions;

public class MainTransitividad {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	SessionFactory sesion_factory = configuration.buildSessionFactory(builder.build());
    	
    	Regions nuevo_continente = null;
//    	Regions nuevo_continente = new Regions();
//    	nuevo_continente.setRegionId(new BigDecimal(222));
//    	nuevo_continente.setRegionName("Nuevo Continente");
    	
    	/*/*//*recupero contienente
    	 * 
    	 */
    	
    	Session sesion = null;
    	Transaction tx = null;
    	try {
    		sesion = sesion_factory.openSession();
    		tx = sesion.beginTransaction();
    		
    		nuevo_continente = (Regions) sesion.get (Regions.class,new BigDecimal(222));
    		
    		
    		Countries nuevo_pais = new Countries();
        	nuevo_pais.setCountryName("Nuevo pais3");
        	nuevo_pais.setCountryId("XE");
        	nuevo_pais.setRegions(nuevo_continente);
        	
        	//nuevo_continente.getCountrieses().add(nuevo_pais);
        	Set<Countries> set_paises = nuevo_continente.getCountrieses();
        	set_paises.add(nuevo_pais);
        	
        	nuevo_continente.setCountrieses(set_paises);
        	
        	//nuevo_continente.setCountrieses(lista_paises);
        	
        	sesion.saveOrUpdate(nuevo_continente);
			
        	tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
    	finally {
    		sesion.close();
    		sesion_factory.close();
    	}
    	
    	/*Countries nuevo_pais = new Countries();
    	nuevo_pais.setCountryName("Nuevo pais");
    	nuevo_pais.setCountryId("NP");
    	
    	nuevo_pais.setRegions(nuevo_continente);
    	
    	Set lista_paises = nuevo_continente.getCountrieses();
    	lista_paises.add(nuevo_pais);
    	
    	Session sesion = null;
    	Transaction tx = null;
    	try {
    		sesion = sesion_factory.openSession();
    		tx = sesion.beginTransaction();
    		
    		sesion.save(nuevo_continente);
    		
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
    	finally {
    		sesion.close();
    		sesion_factory.close();
    	}
    	
 */
    	
	}

}
