package ndyudev.slide5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.slide5.entity.User;

import java.io.IOException;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet({
	"/slide5/tutorial",
	"/slide5/scope",
	"/slide5/login"
})
public class Slide5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Slide5Servlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		User form = new User();
		String message = "";

		if (uri.endsWith("/tutorial")) {
			request.setAttribute("message", "Request Scope");
			request.getSession().setAttribute("message", "Session Scope");
			request.getServletContext().setAttribute("message", "Application Scope");
		} if (uri.endsWith("/login")) {
			try {
				BeanUtils.populate(form, request.getParameterMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(form);

			
			request.setAttribute("user", form);
		} else {

		}

		request.getRequestDispatcher("/views/slide5/loginForm.jsp").forward(request, response);
	}

}
