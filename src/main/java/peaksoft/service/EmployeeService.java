package peaksoft.service;

import peaksoft.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    //CRUD
    String saveEmployee (Employee employee);
    Optional<Employee> getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    String updateEmployeeById(Long employeeId, Employee newEmployee);

    List<Employee> getAllEmployeesSortedBySalary();

    String assignEmployeeToDepartment(Long employeeId, Long departmentId);
    String deleteEmployee(Long id);
}
