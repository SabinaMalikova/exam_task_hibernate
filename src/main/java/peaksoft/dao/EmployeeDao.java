package peaksoft.dao;

import peaksoft.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
             //CRUD
    String saveEmployee (Employee employee);
    Optional<Employee> getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    String updateEmployeeById(Long employeeId, Employee newEmployee);

    List<Employee> getAllEmployeesSortedBySalary();

}
