package org.datanucleus.samples.jpa.tutorial;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityGraph;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.datanucleus.util.NucleusLogger;

public class MyTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tutorial");
		EntityManager em = emf.createEntityManager();
        
        try
        {
            System.out.println("Executing Query for Products with price below 150.00");
            Query q = em.createQuery("SELECT p FROM Product p ");
            List results = q.getResultList();
            Iterator iter = results.iterator();
            while (iter.hasNext())
            {
                Object obj = iter.next();
                System.out.println(">  " + obj);
            }

        }
        catch (Exception e)
        {
            NucleusLogger.GENERAL.error(">> Exception querying data", e);
            System.err.println("Error querying data : " + e.getMessage());
            return;
        }
        finally
        {
            em.close();
            emf.close();
        }
        
        System.out.println("finished");
	}

}
