package ndyudev.lab6.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ndyudev.lab6.dao.UserDAO;
import ndyudev.lab6.entity.User;
import ndyudev.utils.XJpa;

public class UserDAOImpl implements UserDAO {
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
	public List<User> findAll() {
		String jpql = "SELECT u FROM Lab6User u";
		EntityManager em = XJpa.getEntityManager();
		List<User> list = null;
		try {
			TypedQuery<User> listUser = em.createQuery(jpql, User.class);
			list = listUser.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	@Override
	public void create(User entity) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

	@Override
	public void update(User entity) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(String id) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			User entity = em.find(User.class, id);
			if (entity != null) {
				em.remove(entity);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public User findUserByIdOrEmail(String info) {
		EntityManager em = XJpa.getEntityManager();
		User user = null;

		String jpql = "SELECT u FROM Lab6User u WHERE u.id = :info OR u.email = :info";

		try {
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("info", info);

			User result = query.getSingleResult();
			user = result;
		} finally {
			em.close();
		}
		return user;
	}

}