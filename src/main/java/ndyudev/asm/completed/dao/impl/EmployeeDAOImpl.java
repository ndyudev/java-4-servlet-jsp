package ndyudev.asm.completed.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ndyudev.asm.completed.dao.EmployeeDAO;
import ndyudev.asm.completed.entity.Employee;
import ndyudev.utils.XJpa;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(Employee entity) {
        EntityManager em = XJpa.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(entity);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Employee entity) {
        EntityManager em = XJpa.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(entity);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Integer id) { // ID là Integer
        EntityManager em = XJpa.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Employee entity = em.find(Employee.class, id);
            if (entity != null) {
                em.remove(entity);
            }
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public Employee findById(Integer id) { // ID là Integer
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.find(Employee.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Employee> findAll() {
        EntityManager em = XJpa.getEntityManager();
        try {
            String jpql = "SELECT o FROM EmployeeASM o";
            TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}