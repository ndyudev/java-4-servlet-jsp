package ndyudev.lab4.dao.impl;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import ndyudev.lab4.dao.VideoDAO;
import ndyudev.lab4.entity.Video;
import ndyudev.utils.XJpa;

public class VideoDAOImpl implements VideoDAO {
    @Override
    public Video findById(String id) {
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.find(Video.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Video> findAll() {
        String jpql = "SELECT v FROM Lab4Video v";
        EntityManager em = XJpa.getEntityManager();
        List<Video> list = null;
        try {
            TypedQuery<Video> listVideo = em.createQuery(jpql, Video.class);
            list = listVideo.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return list;
    }

    @Override
    public void create(Video entity) {
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
    public void update(Video entity) {
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
            Video entity = em.find(Video.class, id);
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
    
    public List<Video> findVideoByKeyWord(String keyword) {
    	EntityManager em = XJpa.getEntityManager();
    	String jpql = "SELECT v FROM Lab4Video v where v.title like:keyword";
    	try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter("keyword", "%" + keyword + "%");
			List<Video> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    public List<Video> top10VideoView() {
        EntityManager em = XJpa.getEntityManager();
        List<Video> listVideoTop10View = new ArrayList<>();
        
        try {
            String jpql = "SELECT v FROM Lab4Video v ORDER BY v.views DESC"; 
            
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            
            query.setMaxResults(10);
            
            listVideoTop10View = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return listVideoTop10View;
    }
    
    public List<Video> findVideoNoLike() {
        EntityManager em = XJpa.getEntityManager();
        try {
            return em.createNamedQuery("Video.findNoLike", Video.class)
                     .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    
    public List<Object[]> findVideoByKeyword(String keyword) {
        EntityManager em = XJpa.getEntityManager();
        String jpql = "SELECT v.title, COUNT(f), v.active " 
                    + " FROM Lab4Video v "
                    + " LEFT JOIN v.favorites f "
                    + " WHERE v.title LIKE :keyword " 
                    + " GROUP BY v.title, v.active " 
                    + " ORDER BY COUNT(f) DESC";

        try {
        	TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
            
            query.setParameter("keyword", "%" + keyword + "%"); 
            
            List<Object[]> listStats = query.getResultList();
            return listStats;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    
    public List<Video> findFavoriteVideosByUserId(String userId) {
        EntityManager em = XJpa.getEntityManager();

        String jpql = "SELECT f.video FROM Lab4Favorite f WHERE f.user.id = :userId";

        try {
            TypedQuery<Video> query = em.createQuery(jpql, Video.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}