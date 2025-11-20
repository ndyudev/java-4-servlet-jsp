package ndyudev.lab4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab4.dao.impl.ShareDAOImpl;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Lab4Cau1Share
 */
@WebServlet("/lab4/cau1/videoshare")
public class Lab4Cau1ShareServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ShareDAOImpl shareDAO = new ShareDAOImpl();
    public Lab4Cau1ShareServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Object[]> listVideoShare = null;
	    try {
	        listVideoShare = shareDAO.shareVideo();
	    } catch (Exception e) {
	        e.printStackTrace(); 
	    }
	    request.setAttribute("listVideoShare", listVideoShare);
	    
	    request.getRequestDispatcher("/views/lab4/videoShare.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
