package ndyudev.lab2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab2.dao.UserDAO;
import ndyudev.lab2.dao.impl.UserDAOImpl;
import ndyudev.lab2.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({ "/lab2/user/index", "/lab2/user/create", "/lab2/user/delete", "/lab2/user/update", "/lab2/user/edit/*",
		"/lab2/user/reset" })
public class Lab2UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDAO dao = new UserDAOImpl();
		User form = new User();
		String path = request.getServletPath();
		String message = "";
		String pageParam = request.getParameter("page");

		try {
			BeanUtils.populate(form, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// CRUD User
		if (path.startsWith("/lab2/user/create")) {
			try {
				dao.create(form);
				message = "Them user thanh cong";
			} catch (Exception e) {
				message = "Lỗi them user!";
				e.printStackTrace();
			}
		} else if (path.startsWith("/lab2/user/update")) {
			try {
				dao.update(form);
				message = "Cap nhap user thanh cong!";
			} catch (Exception e) {
				message = "Lỗi cập nhập user!";
				e.printStackTrace();
			}
		} else if (path.startsWith("/lab2/user/delete")) {
			try {
				String id = request.getParameter("id");
				dao.deleteById(id);
				message = "Xóa user thành cong!";
			} catch (Exception e) {
				message = "Lỗi xóa user";
				e.printStackTrace();
			}
		} else if (path.startsWith("/lab2/user/edit")) {
			try {
				String id = request.getPathInfo().substring(1);
				User user = dao.findById(id);
				form = user;
				message = "Edit user: " + id;
			} catch (Exception e) {
				message = "Lỗi sửa user!";
				e.printStackTrace();
			}
		} else if (path.startsWith("/lab2/user/reset")) {
			form = new User();
			message = "Đã reset";
		}

		int pageNumber = 1;

		try {
			pageNumber = Integer.parseInt(pageParam);
		} catch (Exception e) {
			pageNumber = 1;
		}

		List<User> listUser = dao.findPageUser(pageNumber, 5);
		int totalRecords = dao.countAllRecord();
		int pageSize = 5;
		int totalPages = totalRecords / pageSize;
		// Kiểm tra xem có dư record nào không
		if (totalRecords % pageSize != 0) {
			totalPages++;
		}

		request.setAttribute("listUser", listUser);
		request.setAttribute("currentPage", pageNumber);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("form", form);
		request.setAttribute("message", message);

		request.getRequestDispatcher("/views/lab2/UserManager.jsp").forward(request, response);
	}
}