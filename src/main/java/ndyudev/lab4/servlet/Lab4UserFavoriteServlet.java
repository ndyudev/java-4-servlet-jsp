package ndyudev.lab4.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab4.dao.impl.FavoriteDAOImpl;
import ndyudev.lab4.dao.impl.UserDAOImpl;
import ndyudev.lab4.dao.impl.VideoDAOImpl;
import ndyudev.lab4.entity.User;
import ndyudev.lab4.entity.Video;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Lab4UserFavoriteServlet
 */
@WebServlet({
    "/lab4/report/userfavorites",
    "/lab4/report/userfavorites/delete"
})
public class Lab4UserFavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Lab4UserFavoriteServlet() {
		super();
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDAOImpl userDAO = new UserDAOImpl();
	    VideoDAOImpl videoDAO = new VideoDAOImpl();
	    FavoriteDAOImpl favoriteDAO = new FavoriteDAOImpl();

	    String uri = request.getRequestURI();

	    if (uri.contains("delete")) {
	        String userId = request.getParameter("userId");
	        String videoId = request.getParameter("videoId");

	        favoriteDAO.deleteByUserAndVideo(userId, videoId);

	        response.sendRedirect(request.getContextPath()
	                + "/lab4/report/userfavorites?userId=" + userId);
	        return;
	    }

	    List<User> userList = userDAO.findAll();
	    request.setAttribute("userList", userList);

	    String select = request.getParameter("userId");
	    if (select == null) {
	        select = userList.get(0).getId();
	    }
	    request.setAttribute("selectedUserId", select);

	    List<Video> favoriteVideos = videoDAO.findFavoriteVideosByUserId(select);
	    request.setAttribute("favoriteVideos", favoriteVideos);

	    request.getRequestDispatcher("/views/lab4/userFavorite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
