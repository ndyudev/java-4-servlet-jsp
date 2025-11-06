package ndyudev.lab1;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ndyudev.lab1.dao.impl.UserDAOImpl;
import ndyudev.lab1.entity.User;

public class Lab1User {
	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();

//		List<User> userFPT = dao.finAllFPTEdu();
//		
//		for (User user : userFPT) {
//			System.out.println(user);
//		}

//		User user1 = new User("U016", "fpt123","Châu Nhật Duy", "Chauunhatduyyit@gmail.com", true );
//		dao.create(user1);

//		List<User> user = dao.findAll();
//		
//		for (User userAll : user) {
//			System.out.println(userAll);
//		}
//		User user1 = new User("U016", "fpt124","Châu Nhật Duy", "Chauunhatduyyit@gmail.com", true );
//		dao.update(user1);

//		User userFind = dao.findById("U016");
//		System.out.println(userFind);

		try {
			dao.deleteById("U016");
			System.out.println("Xoa thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Xoa khong thanh cong");
		}
	    int pageNumber = 3;
	    int pageSize = 5;
		
	    List<User> pageUsers = dao.findPageUser(pageNumber, pageSize);

	    System.out.println("Trang:" + pageNumber);
	    for (User u : pageUsers) {
	        System.out.println(u);
	    }

	}
}
