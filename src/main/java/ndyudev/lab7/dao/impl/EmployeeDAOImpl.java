package ndyudev.lab7.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ndyudev.lab7.dao.EmployeeDAO;
import ndyudev.lab7.entity.Employee;
import ndyudev.utils.XJpa;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findById(String id) {
		EntityManager em = XJpa.getEntityManager();
		try {
			return em.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public List<Employee> findAll() {
		EntityManager em = XJpa.getEntityManager();
		String jpql = "SELECT e FROM Employee e";
		List<Employee> list = null;
		try {
			TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return list;
	}

	@Override
	public void create(Employee employee) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public void update(Employee employee) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}
	}

	@Override
	public void delete(String id) {
		EntityManager em = XJpa.getEntityManager();
		try {
			em.getTransaction().begin();
			Employee employee = em.find(Employee.class, id);
			if (employee != null) {
				em.remove(employee);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			em.close();
		}
	}
}