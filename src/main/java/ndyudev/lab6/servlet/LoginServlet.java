package ndyudev.lab6.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import ndyudev.lab6.entity.*;
import ndyudev.lab6.filter.*;
import ndyudev.lab6.dao.impl.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/lab6/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAOImpl dao = new UserDAOImpl(); 
	    User user = dao.findUserByIdOrEmail(username);
	    if(user == null) {
	    	request.setAttribute("message", "Invalid username");
	    	request.getRequestDispatcher("/views/lab6/login.jsp").forward(request, response);
	    }else if(!user.getPassword().equals(password)){
	    	request.setAttribute("message", "Invalid password");
	    	request.getRequestDispatcher("/views/lab6/login.jsp").forward(request, response);
	    }else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("user", user);
	    	request.setAttribute("message", "Login successfully");
	    	
	    	String securityUri = (String) session.getAttribute(AuthFilter.SECURITY_URL);
	    	if(securityUri != null) {
	    		session.removeAttribute(AuthFilter.SECURITY_URL);
	    		response.sendRedirect(securityUri);
	    		return;
	    	}
	    	String defaultUri = request.getContextPath() + "/video/list";
	        response.sendRedirect(defaultUri);
	        return;
	    }
	    request.getRequestDispatcher("/views/lab6/login.jsp").forward(request, response);
	}

}
