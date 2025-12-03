package ndyudev.lab7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.lab7.dao.EmployeeDAO;
import ndyudev.lab7.dao.impl.EmployeeDAOImpl;
import ndyudev.lab7.entity.Employee;
import ndyudev.utils.RestIO;

import java.io.IOException;

@WebServlet("/lab7/restfullapi/employee/*")
public class EmployRestfulAPI extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmployRestfulAPI() {
        super();
    }

    private EmployeeDAO dao = new EmployeeDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getPathInfo();

        if (info == null || info.length() <= 1) {
            RestIO.writeObject(response, dao.findAll());
        } else {
            String id = info.substring(1);
            RestIO.writeObject(response, dao.findById(id));
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee emp = RestIO.readObject(request, Employee.class);
        dao.create(emp);
        RestIO.writeObject(response, emp);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String info = request.getPathInfo();
        String id = (info != null && info.length() > 1) ? info.substring(1) : null;

        Employee emp = RestIO.readObject(request, Employee.class);

        if (id != null) {
            emp.setId(id);
        }

        dao.update(emp);
        RestIO.writeObject(response, emp);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = request.getPathInfo();

        if (info != null && info.length() > 1) {
            String id = info.substring(1);
            dao.delete(id);
            RestIO.writeEmptyObject(response);
        } else {
            response.sendError(400, "Vui lòng cung cấp ID để xóa");
        }
    }
}