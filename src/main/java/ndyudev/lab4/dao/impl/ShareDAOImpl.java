package ndyudev.lab4.dao.impl;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import ndyudev.lab4.dao.ShareDAO;
import ndyudev.lab4.entity.Share;
import ndyudev.utils.XJpa;

public class ShareDAOImpl implements ShareDAO {
    @Override
    public Share findById(Long id) {
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.find(Share.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Share> findAll() {
        String jpql = "SELECT s FROM Lab4Share s";
        EntityManager em = XJpa.getEntityManager();
        List<Share> list = null;
        try {
            TypedQuery<Share> listShare = em.createQuery(jpql, Share.class);
            list = listShare.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public void create(Share entity) {
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
    public void update(Share entity) {
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
            Share entity = em.find(Share.class, id);
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
    
    public List<Share> VideoShareIn2024() {
    	EntityManager em = XJpa.getEntityManager();
    	try {
			TypedQuery<Share> query = em.createNamedQuery("Share.VideoShareIn2024", Share.class);
			List<Share> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
    	return null;
    }
    
    public List<Object[]> shareVideo(){
        EntityManager em = XJpa.getEntityManager();
        String jpql = "SELECT s.video.title, COUNT(s), MIN(s.shareDate), MAX(s.shareDate) "
                    + " FROM Lab4Share s "
                    + " GROUP BY s.video.title " 
                    + " ORDER BY COUNT(s) DESC";
        try {
            TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class); 
            
            List<Object[]> listVideoShare = query.getResultList();
            return listVideoShare;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }
}