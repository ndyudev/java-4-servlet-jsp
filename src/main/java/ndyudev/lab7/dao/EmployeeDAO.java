package ndyudev.lab7.dao;

import java.util.List;

import ndyudev.lab7.entity.Employee;

public interface EmployeeDAO {
	
	Employee findById(String id);

    List<Employee> findAll();

    void create(Employee employee);

    void update(Employee employee);

    void delete(String id);
}
