package ndyudev.slider1.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ndyudev.slider1.entity.*;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Slider_1_Student");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		try {
			Student st = new Student("Duy", 2000.0);
			em.persist(st);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}
}
