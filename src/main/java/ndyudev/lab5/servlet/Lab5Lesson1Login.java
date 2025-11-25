package ndyudev.lab5.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ndyudev.lab5.entity.User;
import ndyudev.lab5.service.UserService;

import java.io.IOException;

@WebServlet("/lab5/lesson1/login")
public class Lab5Lesson1Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserService();

    public Lab5Lesson1Login() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/views/lab5/Lesson1Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("username");
        String pass = request.getParameter("password");
        
        User user = userService.findById(id);
        
        if (user == null) {
            request.setAttribute("message", "Sai id");
        } else if (!pass.equals(user.getPassword())) {
            request.setAttribute("message", "Sai password");
        } else {
            request.setAttribute("message", "Login thành công");
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            request.setAttribute("username", id); 
        }
        
        request.getRequestDispatcher("/views/lab5/Lesson1Login.jsp").forward(request, response);
    }
}