package ndyudev.lab7.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ndyudev.utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ndyudev.lab7.entity.*;

@WebServlet("/lab7/employees/*")
public class EmployeeRestServlet extends HttpServlet {
	private Map<String, Employee> map = new HashMap<>(
			Map.of(
					"NV01", new Employee("NV01", "Nhân viên 01", true, 500.0),
					"NV02", new Employee("NV02", "Nhân viên 02", false, 1500.0), 
					"NV03", new Employee("NV03", "Nhân viên 03", true, 5000.0), 
					"NV04", new Employee("NV04", "Nhân viên 04", false, 2500.0),
					"NV05", new Employee("NV05", "Nhân viên 05", true, 3500.0)));

	// GET:/employees
	// GET:/employees/ID
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String info = req.getPathInfo();
		if(info == null || info.length() == 0) {
			RestIO.writeObject(resp, map.values());
		} else {
			String id = info.substring(1).trim();
			RestIO.writeObject(resp, map.get(id));
		}
	}

	// POST:/employees
		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee employee = RestIO.readObject(req, Employee.class);
		map.put(employee.getId(), employee);
		RestIO.writeObject(resp, employee);
	}

	// PUT:/employees/ID
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getPathInfo().substring(1).trim();
		Employee employee = RestIO.readObject(req, Employee.class);
		map.put(id, employee);
		RestIO.writeEmptyObject(resp);
	}

	// DELETE:/employees/ID
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getPathInfo().substring(1).trim();
		//System.out.println(id);
		map.remove(id);
		RestIO.writeEmptyObject(resp);
	}
}
