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
        List<Video> results = null;
        String message = "";
        
        if (keyword != null && !keyword.trim().isEmpty()) {
            try {
                // 2. Gọi DAO
                results = videoDAO.findVideoByKeyWord(keyword);
                
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
        
        // 3. Đặt kết quả và thông báo vào request
        request.setAttribute("keyword", keyword); // Giữ lại từ khóa đã nhập
        request.setAttribute("results", results);
        request.setAttribute("message", message);
        
        // 4. Chuyển tiếp lại trang tìm kiếm để hiển thị kết quả
		request.getRequestDispatcher("/views/lab4/searchVideo.jsp").forward(request, response);
	}
}