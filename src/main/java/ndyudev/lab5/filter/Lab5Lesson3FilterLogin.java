package ndyudev.lab5.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import ndyudev.lab5.entity.Log;
import ndyudev.lab5.entity.User;
import ndyudev.lab5.service.LogService;

@WebFilter("/*")
public class Lab5Lesson3FilterLogin extends HttpFilter implements Filter {

    private static final long serialVersionUID = 1L;
    LogService logService = new LogService();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        
        Log log = new Log();
        log.setUrl(req.getRequestURI());
        
        if (user != null) {
            log.setUsername(user.getId());
        } else {
            log.setUsername(null);
        }

        logService.create(log);

        chain.doFilter(request, response);
    }
}
