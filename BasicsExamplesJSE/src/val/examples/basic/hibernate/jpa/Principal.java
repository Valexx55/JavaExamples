package val.examples.basic.hibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal 
    {
    public Principal() 
    {
    }

    public static void main(String[] args) 
        {
        long empId = 190;  // emp 190 - Timothy Gates
        Employee yo = null;
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        yo = em.find(Employee.class, empId);
        System.out.println(yo.toString());
        //em.persist(yo);
        em.getTransaction().commit();
        } catch (Exception e) {
        
        e.printStackTrace();
        }finally {
        em.close();
        System.exit(0);//no sé pporqué no acaba sólo...parace que se queda conlgando si no le pongo esto
        
        }
       }
}