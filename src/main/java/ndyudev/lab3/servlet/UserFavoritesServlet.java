package ndyudev.lab3.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab3.dao.UserDAO;
import ndyudev.lab3.dao.FavoriteDAO;
import ndyudev.lab3.dao.impl.UserDAOImpl;
import ndyudev.lab3.dao.impl.FavoriteDAOImpl;
import ndyudev.lab3.entity.User;
import ndyudev.lab3.entity.Favorite;
import ndyudev.lab3.entity.Video;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/lab3/userFavorites")
public class UserFavoritesServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();
    private FavoriteDAO favoriteDAO = new FavoriteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        
        User user = userDAO.findById(userId);

            List<Favorite> favorites = favoriteDAO.findByUserId(userId);
            List<Video> videos = new ArrayList<>();
            for (Favorite favorite : favorites) {
                videos.add(favorite.getVideo());
            }
            req.setAttribute("user", user);
            req.setAttribute("videos", videos);
            req.setAttribute("favorites", favorites);

        req.getRequestDispatcher("/views/lab3//userFavorites.jsp").forward(req, resp);
    }
}