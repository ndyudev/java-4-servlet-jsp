package ndyudev.lab6.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import ndyudev.lab6.entity.*;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter({"/admin/*",	"/account/change-password",	"/account/edit-profile", "/video/like/*", "/video/share/*"})
public class AuthFilter extends HttpFilter implements Filter {
    public static final String SECURITY_URL = "";
   
    public AuthFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String uri = req.getRequestURI();
		
		String message = "";

	    if (user == null) {
	        message = "Đăng nhập để dùng.";
	        
	    } else if (uri.contains("/admin") && !user.getAdmin()) {
	        message = "Không đủ quyền.";
	    }

	    if (!message.isEmpty()) { 
	        session.setAttribute("securityMessage", message); 
	        session.setAttribute(AuthFilter.SECURITY_URL, uri);
	        resp.sendRedirect(req.getContextPath() + "/login");
	        return;
	    } else {
	        chain.doFilter(request, response);
	    }
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
