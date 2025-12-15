package ndyudev.asm.completed.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.asm.completed.dao.DepartmentDAO;
import ndyudev.asm.completed.dao.EmployeeDAO;
import ndyudev.asm.completed.dao.impl.DepartmentDAOImpl;
import ndyudev.asm.completed.dao.impl.EmployeeDAOImpl;
import ndyudev.asm.completed.entity.Department;
import ndyudev.asm.completed.entity.Employee;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet({ 
    "/asm/completed/employee/index", 
    "/asm/completed/employee/create", 
    "/asm/completed/employee/update",
    "/asm/completed/employee/delete", 
    "/asm/completed/employee/edit", 
    "/asm/completed/employee/reset" 
})
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final EmployeeDAO empDAO = new EmployeeDAOImpl();
    private final DepartmentDAO deptDAO = new DepartmentDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();

        Employee emp = null;
        String id = request.getParameter("id");

        if (uri.contains("delete")) {
            if (id != null) {
                try {
                    empDAO.delete(Integer.parseInt(id));
                    request.setAttribute("message", "Xóa thành công!");
                } catch (Exception e) {
                    request.setAttribute("error", "Lỗi khi xóa!");
                    e.printStackTrace();
                }
            }
            emp = new Employee(); 

        } else if (uri.contains("edit")) {
            if (id != null) {
                try {
                    emp = empDAO.findById(Integer.parseInt(id));
                } catch (NumberFormatException e) {
                }
            }

        } else if (uri.contains("reset")) {
            emp = new Employee();
        }

        if (emp == null)
            emp = new Employee();
        request.setAttribute("item", emp);

        request.setAttribute("departments", deptDAO.findAll());

        String dpId = request.getParameter("dpId");
        List<Employee> list = empDAO.findAll();

        if (dpId != null && !dpId.isEmpty()) {
            list = list.stream()
                .filter(e -> e.getDepartment() != null && e.getDepartment().getId().equals(dpId))
                .collect(Collectors.toList());
        }

        request.setAttribute("employees", list);


        request.getRequestDispatcher("/views/asm/completed/EmployeeManager.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getRequestURI();
        Employee emp = new Employee();

        try {
            BeanUtils.populate(emp, request.getParameterMap());
            
            String selectedDeptId = request.getParameter("dp_id"); 
            if(selectedDeptId != null && !selectedDeptId.isEmpty()){
                Department d = new Department();
                d.setId(selectedDeptId);
                emp.setDepartment(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (uri.contains("create")) {
            try {
                if(emp.getId() != null && empDAO.findById(emp.getId()) != null) {
                    request.setAttribute("error", "Mã nhân viên đã tồn tại!");
                } else {
                    empDAO.create(emp);
                    request.setAttribute("message", "Thêm mới thành công!");
                }
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi thêm mới!");
                e.printStackTrace();
            }
        } else if (uri.contains("update")) {
            try {
                empDAO.update(emp);
                request.setAttribute("message", "Cập nhật thành công!");
            } catch (Exception e) {
                request.setAttribute("error", "Lỗi cập nhật!");
                e.printStackTrace();
            }
        }

        doGet(request, response);
    }
}