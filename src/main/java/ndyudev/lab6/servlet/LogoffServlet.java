package ndyudev.lab6.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logoff")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Xóa session
		request.getSession().invalidate();
		
		// Quay về trang chủ (hoặc trang login)
		response.sendRedirect(request.getContextPath() + "/video/list");
	}
}