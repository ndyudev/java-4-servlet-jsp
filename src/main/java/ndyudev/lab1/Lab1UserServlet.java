package ndyudev.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab1.dao.impl.UserDAOImpl;
import ndyudev.lab1.entity.User;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Lab1UserServlet
 */
@WebServlet("/lab1/user")
public class Lab1UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAOImpl dao = new UserDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lab1UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = dao.findAll();
		request.setAttribute("listUsers", list);
		request.getRequestDispatcher("/views/lab1/User.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
