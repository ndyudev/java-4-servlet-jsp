package ndyudev.lab4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab4.dao.impl.VideoDAOImpl;
import ndyudev.lab4.entity.Video;

import java.io.IOException;
import java.util.List;

@WebServlet("/lab4/cau3/searchVideo")
public class Lab4SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private VideoDAOImpl videoDAO = new VideoDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/lab4/searchVideo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
	    List<Object[]> results = null;
	    String message = "";
	    
	    if (keyword != null && !keyword.trim().isEmpty()) {
	        try {
	            results = videoDAO.findVideoByKeyword(keyword); 
	            
	            if (results.isEmpty()) {
	                message = "Không tìm thấy video nào chứa từ khóa: '" + keyword + "'";
	            } else {
	                message = "Tìm thấy " + results.size() + " video.";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            message = "Lỗi truy vấn cơ sở dữ liệu.";
	        }
	    } else {
	        message = "Vui lòng nhập từ khóa tìm kiếm.";
	    }
	    
	    request.setAttribute("keyword", keyword);
	    request.setAttribute("results", results);
	    request.setAttribute("message", message);
	    
	    request.getRequestDispatcher("/views/lab4/searchVideo.jsp").forward(request, response);
	}
}