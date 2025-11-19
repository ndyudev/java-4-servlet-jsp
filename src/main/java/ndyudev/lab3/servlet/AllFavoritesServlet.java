package ndyudev.lab3.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab3.dao.FavoriteDAO;
import ndyudev.lab3.dao.impl.FavoriteDAOImpl;
import ndyudev.lab3.entity.Favorite;
import java.io.IOException;
import java.util.List;

@WebServlet("/lab3/allFavorites")
public class AllFavoritesServlet extends HttpServlet {
    private FavoriteDAO favoriteDAO = new FavoriteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Favorite> favorites = favoriteDAO.findAll();
        req.setAttribute("favorites", favorites);
        req.getRequestDispatcher("/views/lab3/allFavorites.jsp").forward(req, resp);
    }
}