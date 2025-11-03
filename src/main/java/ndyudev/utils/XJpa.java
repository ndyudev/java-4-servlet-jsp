package ndyudev.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class XJpa {
	private static EntityManagerFactory factory;
	static {
		factory = Persistence.createEntityManagerFactory("demo_jpa");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
