package ndyudev.asm.completed.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.completed.dao.DepartmentDAO;
import ndyudev.asm.completed.dao.impl.DepartmentDAOImpl;
import ndyudev.asm.completed.entity.Department;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({
    "/asm/completed/department/index",
    "/asm/completed/department/create",
    "/asm/completed/department/update",
    "/asm/completed/department/delete",
    "/asm/completed/department/edit",
    "/asm/completed/department/reset"
})
public class DepartmentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final DepartmentDAO deptDAO = new DepartmentDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        Department item = null;
        String id = request.getParameter("id");

        if (uri.contains("delete")) {
            if (id != null) {
                try {
                    deptDAO.delete(id);
                    request.setAttribute("message", "Xóa thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Không thể xóa! Phòng ban này đang có nhân viên.");
                }
            }
            item = new Department();
            
        } else if (uri.contains("edit")) {
            if (id != null) {
                item = deptDAO.findById(id);
            }
            
        } else if (uri.contains("reset")) {
            item = new Department();
        }

        if (item == null) item = new Department();
        request.setAttribute("item", item);

        List<Department> list = deptDAO.findAll();
        request.setAttribute("items", list);

        request.getRequestDispatcher("/views/asm/completed/DepartmentManager.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        Department item = new Department();
        
        try {
            BeanUtils.populate(item, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (uri.contains("create")) {
            try {
                if(deptDAO.findById(item.getId()) != null) {
                    request.setAttribute("error", "Mã phòng ban đã tồn tại!");
                } else {
                    deptDAO.create(item);
                    request.setAttribute("message", "Thêm mới thành công!");
                }
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi thêm mới!");
                e.printStackTrace();
            }
            
        } else if (uri.contains("update")) {
            try {
                deptDAO.update(item);
                request.setAttribute("message", "Cập nhật thành công!");
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi cập nhật!");
                e.printStackTrace();
            }
        }

        doGet(request, response);
    }
} 