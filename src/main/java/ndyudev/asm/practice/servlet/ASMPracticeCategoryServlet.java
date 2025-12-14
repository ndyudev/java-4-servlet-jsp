package ndyudev.asm.practice.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.practice.dao.CategoryDAO;
import ndyudev.asm.practice.dao.impl.CategoryDAOImpl;
import ndyudev.asm.practice.entity.Category;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet({
    "/asm/practice/category/index",
    "/asm/practice/category/create",
    "/asm/practice/category/update",
    "/asm/practice/category/delete",
    "/asm/practice/category/edit",
    "/asm/practice/category/reset"
})
public class ASMPracticeCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private final CategoryDAO catDAO = new CategoryDAOImpl();

    public ASMPracticeCategoryServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        Category item = null;
        String id = request.getParameter("id");

        if (uri.contains("delete")) {
            if (id != null) {
                try {
                    catDAO.delete(id);
                    request.setAttribute("message", "Xóa thành công!");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Không thể xóa! Danh mục này đang chứa sản phẩm.");
                }
            }
            item = new Category();
            
        } else if (uri.contains("edit")) {
            if (id != null) {
                item = catDAO.findById(id);
            }
            
        } else if (uri.contains("reset")) {
            item = new Category();
        }

        if (item == null) item = new Category();
        request.setAttribute("item", item);

        List<Category> list = catDAO.findAll();
        request.setAttribute("items", list);

        request.getRequestDispatcher("/views/asm/practice/CategoryManager.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        Category item = new Category();
        
        try {
            BeanUtils.populate(item, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (uri.contains("create")) {
            try {
                if(catDAO.findById(item.getId()) != null) {
                    request.setAttribute("error", "Mã loại đã tồn tại!");
                } else {
                    catDAO.create(item);
                    request.setAttribute("message", "Thêm mới thành công!");
                }
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi thêm mới!");
            }
            
        } else if (uri.contains("update")) {
            try {
                catDAO.update(item);
                request.setAttribute("message", "Cập nhật thành công!");
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi cập nhật!");
            }
        }

        doGet(request, response);
    }
}