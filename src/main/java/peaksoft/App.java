package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Department;
import peaksoft.entity.Employee;
import peaksoft.service.DepartmentService;
import peaksoft.service.EmployeeService;
import peaksoft.service.serviceImpl.DepartmentServiceImpl;
import peaksoft.service.serviceImpl.EmployeeServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DepartmentService departmentService = new DepartmentServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        while (true){
            System.out.println("""
                    1. saveEmployee
                    2. getEmployeeById
                    3. getAllEmployees
                    4. updateEmployeeById
                    5. getAllEmployeesSortedBySalary
                    6. delete employee 
                    --------------------------------
                    7. saveDepartment
                    8. getDepartmentById
                    9. getAllDepartments
                    10. updateDepartment
                    11.assign employee to department 
                    12.delete department 
                    """);
            switch (new Scanner(System.in).nextLine()){
                case "1" -> {
                    Employee employee1 = new Employee("Artem","Karaev",35,85.000);
                    Employee employee2 = new Employee("Sasha","Igoreva",28,40.000);
                    Employee employee3 = new Employee("Dasha", "Alekseeva", 25, 20.000);
                    System.out.println(employeeService.saveEmployee(employee2));
                    System.out.println(employeeService.saveEmployee(employee1));
                    System.out.println(employeeService.saveEmployee(employee3));
                }
                case "2" -> {
                    System.out.println(employeeService.getEmployeeById(1L));
                }
                case "3" -> {
                    System.out.println(employeeService.getAllEmployees());
                }
                case "4" -> {
                    Employee employee = new Employee("Masha","Borisova",40,55.000);
                    System.out.println(employeeService.updateEmployeeById(1L,employee));
                }
                case "5" -> {
                    System.out.println(employeeService.getAllEmployeesSortedBySalary());
                }
                case "6" -> {
                    System.out.println(employeeService.deleteEmployee(1L));
                }
                case "7" -> {
                    Department department1 = new Department("surgeon", 7);
                    Department department2 = new Department("ocular",5);
                    Department department3 = new Department("farm",9);
                    System.out.println(departmentService.saveDepartment(department3));
                    System.out.println(departmentService.saveDepartment(department1));
                    System.out.println(departmentService.saveDepartment(department2));
                }
                case "8" -> {
                    System.out.println(departmentService.getDepartmentById(1L));
                }
                case "9" -> {
                    System.out.println(departmentService.getAllDepartments());
                }
                case "10" -> {
                    Department department = new Department("cardiologist", 4);
                    System.out.println(departmentService.updateDepartment(2L, department));
                }
                case "11" -> {
                    System.out.println(employeeService.assignEmployeeToDepartment(1L, 2L));
                    System.out.println(employeeService.assignEmployeeToDepartment(2L, 1L));
                    System.out.println(employeeService.assignEmployeeToDepartment(3L, 3L));
                }
                case "12" -> {
                    System.out.println(departmentService.deleteDepartment(3L));
                }
            }
        }
    }
}
