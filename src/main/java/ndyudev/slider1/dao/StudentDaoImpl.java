package ndyudev.slider1.dao;

import jakarta.persistence.EntityManager;
import ndyudev.slider1.entity.Student;
import ndyudev.utils.XJpa;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void create(Student item) {
		EntityManager em = XJpa.getEntityManager();
		em.getTransaction().begin();
		em.persist(item); // lưu đối tượng vào Database
		em.getTransaction().commit();
	}
	// test
}
