package peaksoft.service.serviceImpl;

import peaksoft.dao.EmployeeDao;
import peaksoft.dao.daoImpl.EmployeeDaoImpl;
import peaksoft.entity.Employee;
import peaksoft.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public String saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public String updateEmployeeById(Long employeeId, Employee newEmployee) {
        return employeeDao.updateEmployeeById(employeeId,newEmployee);
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalary() {
        return employeeDao.getAllEmployeesSortedBySalary();
    }

    @Override
    public String assignEmployeeToDepartment(Long employeeId, Long departmentId) {
        return employeeDao.assignEmployeeToDepartment(employeeId,departmentId);
    }

    @Override
    public String deleteEmployee(Long id) {
        return employeeDao.deleteEmployee(id);
    }
}
