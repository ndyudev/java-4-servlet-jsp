package ndyudev.lab1.dao;

import ndyudev.lab1.entity.Student;
import jakarta.persistence.EntityManager;
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
