package ndyudev.lab5.service;

import jakarta.persistence.EntityManager;
import ndyudev.lab5.entity.User;
import ndyudev.utils.XJpa;

public class UserService {
	public User findById(String keyword) {
		EntityManager em = XJpa.getEntityManager();
		try {
			return em.find(User.class,keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}
}
