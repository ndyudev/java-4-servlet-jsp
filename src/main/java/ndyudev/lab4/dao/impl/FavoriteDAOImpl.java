package ndyudev.lab4.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ndyudev.lab4.dao.FavoriteDAO;
import ndyudev.lab4.entity.Favorite;
import ndyudev.utils.XJpa;

public class FavoriteDAOImpl implements FavoriteDAO {
    @Override
    public Favorite findById(Long id) {
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.find(Favorite.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Favorite> findAll() {
        String jpql = "SELECT f FROM Lab3Favorite f";
        EntityManager em = XJpa.getEntityManager();
        List<Favorite> list = null;
        try {
            TypedQuery<Favorite> listFavorite = em.createQuery(jpql, Favorite.class);
            list = listFavorite.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public void create(Favorite entity) {
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
    public void update(Favorite entity) {
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
    public void delete(Long id) {
        EntityManager em = XJpa.getEntityManager();
        try {
            em.getTransaction().begin();
            Favorite entity = em.find(Favorite.class, id);
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

    @Override
    public List<Favorite> findByUserId(String userId) {
        String jpql = "SELECT f FROM Lab4Favorite f WHERE f.user.id = :userId";
        EntityManager em = XJpa.getEntityManager();
        List<Favorite> list = null;
        try {
            TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
            query.setParameter("userId", userId);
            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }
}