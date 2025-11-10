package ndyudev.lab2.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ndyudev.lab2.dao.UserDAO;
import ndyudev.lab2.entity.User;
import ndyudev.utils.XJpa;

public class UserDAOImpl implements UserDAO {
	@Override
	public void create(User user) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<User> findAll() {
		EntityManager em = XJpa.getEntityManager();
		try {
			TypedQuery<User> query = em.createQuery("SELECT u FROM Lab2User u", User.class); // Đã fix
			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public User findById(String id) {
		EntityManager em = XJpa.getEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			em.close();
		}
	}

	@Override
	public void update(User user) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void deleteById(String id) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			User u = em.find(User.class, id);
			if (u != null) {
				em.remove(u);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public List<User> findAllFPTEdu() {
		EntityManager em = XJpa.getEntityManager();
		String queryFPT = "SELECT u FROM Lab2User u WHERE u.email LIKE :emailFPT AND u.admin = :admin"; // Fix: Lab2User
		try {
			TypedQuery<User> queryUserFPT = em.createQuery(queryFPT, User.class);
			queryUserFPT.setParameter("emailFPT", "%@fpt.edu.vn");
			queryUserFPT.setParameter("admin", false);
			return queryUserFPT.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public List<User> findPageUser(int pageNumber, int pageSize) {
		EntityManager em = XJpa.getEntityManager();
		String jpql = "SELECT u FROM Lab2User u";
		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			if (pageNumber <= 0) {
				pageNumber = 1;
			}
			
			if (pageSize <= 0) {
				pageSize  = 5;
			}
			int startPosition = (pageNumber - 1) * pageSize;

			query.setFirstResult(startPosition);
			query.setMaxResults(pageSize);

			return query.getResultList();
		} finally {
			em.close();
		}
	}

	@Override
	public int countAllRecord() {
		EntityManager em = XJpa.getEntityManager();
		String jpql = "SELECT COUNT(u) FROM Lab2User u";
		try {
			Long longCount = em.createQuery(jpql, Long.class).getSingleResult();
			return longCount.intValue();
		} finally {
			em.close();
		}
	}
}