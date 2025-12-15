package ndyudev.asm.completed.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import ndyudev.asm.completed.dao.DepartmentDAO;
import ndyudev.asm.completed.entity.Department;
import ndyudev.utils.XJpa;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void create(Department entity) {
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
    public void update(Department entity) {
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
    public void delete(String id) {
        EntityManager em = XJpa.getEntityManager();
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Department entity = em.find(Department.class, id);
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
    public Department findById(String id) {
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.find(Department.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Department> findAll() {
        EntityManager em = XJpa.getEntityManager();
        try {
            String jpql = "SELECT o FROM Department o";
            TypedQuery<Department> query = em.createQuery(jpql, Department.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}