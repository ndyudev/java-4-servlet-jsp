package ndyudev.lab1.dao;

import ndyudev.lab1.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo_jpa");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		try {
			Student st = new Student("Lan",2000.0);
			em.persist(st);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();
	}
}
