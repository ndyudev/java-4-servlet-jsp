package ndyudev.lab4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab4.dao.impl.UserDAOImpl;
import ndyudev.lab4.entity.User;

import java.io.IOException;

@WebServlet("/lab4/cau2/login")
public class Lab4LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAOImpl userDAO = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/lab4/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("user");
	    String password = request.getParameter("password");
	    
	    User user = userDAO.findUserByIdOrEmail(info);

	    if (user != null) {
	        if (user.getPassword().equals(password)) {
	            request.setAttribute("message", "Đăng nhập thành công! Chào mừng, " + user.getFullName()); 
	            
	            user.setPassword(null);
	            request.setAttribute("user", user);
	        } else {
	            request.setAttribute("message", "Sai mật khẩu. Vui lòng thử lại.");
	        }
	    } else {
	        request.setAttribute("message", "Tài khoản hoặc Email không tồn tại.");
	    }
	    
	    request.getRequestDispatcher("/views/lab4/login.jsp").forward(request, response);
	}
}