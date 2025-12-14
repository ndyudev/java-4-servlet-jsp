package ndyudev.asm.practice.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.practice.dao.CategoryDAO;
import ndyudev.asm.practice.dao.ProductDAO;
import ndyudev.asm.practice.dao.impl.CategoryDAOImpl;
import ndyudev.asm.practice.dao.impl.ProductDAOImpl;
import ndyudev.asm.practice.entity.Category;
import ndyudev.asm.practice.entity.Product;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet({ "/asm/practice/product/index", "/asm/practice/product/create", "/asm/practice/product/update",
        "/asm/practice/product/delete", "/asm/practice/product/edit", "/asm/practice/product/reset" })
public class ASMPracticeProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final ProductDAO proDAO = new ProductDAOImpl();
    private final CategoryDAO catDAO = new CategoryDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        Product p = null;
        String id = request.getParameter("id");

        if (uri.contains("delete")) {
            if (id != null) {
                proDAO.delete(Integer.parseInt(id));
                request.setAttribute("message", "Xóa thành công!");
            }
            p = new Product(); 

        } else if (uri.contains("edit")) {
            if (id != null) {
                p = proDAO.findById(Integer.parseInt(id));
            }

        } else if (uri.contains("reset")) {
            p = new Product();
        }

        if (p == null)
            p = new Product();
        request.setAttribute("item", p);

        request.setAttribute("cates", catDAO.findAll());

        String cid = request.getParameter("cid");
        List<Product> list = proDAO.findAll();

        if (cid != null && !cid.isEmpty()) {
            list = list.stream()
                .filter(prod -> prod.getCategory() != null && prod.getCategory().getId().equals(cid))
                .collect(Collectors.toList());
        }

        request.setAttribute("products", list);

        request.getRequestDispatcher("/views/asm/practice/ProductManager.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        Product p = new Product();

        try {
            BeanUtils.populate(p, request.getParameterMap());
            
            String catId = request.getParameter("category_id");
            Category c = new Category();
            c.setId(catId);
            p.setCategory(c);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (uri.contains("create")) {
            try {
                proDAO.create(p);
                request.setAttribute("message", "Thêm mới thành công!");
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi thêm mới!");
            }
        } else if (uri.contains("update")) {
            try {
                proDAO.update(p);
                request.setAttribute("message", "Cập nhật thành công!");
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi cập nhật!");
            }
        }

        doGet(request, response);
    }
}