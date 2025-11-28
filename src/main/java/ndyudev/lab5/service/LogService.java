package ndyudev.lab5.service;

import ndyudev.lab5.entity.Log;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ndyudev.utils.XJpa;

public class LogService {
	public void create(Log log) {
		EntityManager em = XJpa.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(log); 
            trans.commit();
        } catch (Exception e) {
            if (trans.isActive()) {
                trans.rollback();
            }
            System.err.println("誤り: " + e.getMessage());
        } finally {
            em.close();
        }
    }
}
