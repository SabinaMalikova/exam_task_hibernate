package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.w3c.dom.html.HTMLObjectElement;
import peaksoft.HibernateConfig;
import peaksoft.dao.EmployeeDao;
import peaksoft.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public String saveEmployee(Employee employee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            return "successfully saved";
        }catch (HibernateException e){
            return e.getMessage();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Long employeeId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = null;
        try{
            entityManager.getTransaction().begin();
            employee = entityManager.find(Employee.class,employeeId);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return Optional.ofNullable(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Employee>employees = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();
            employees = entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return employees;
    }

    @Override
    public String updateEmployeeById(Long employeeId, Employee newEmployee) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Employee employee = entityManager.find(Employee.class, employeeId);
            employee.setFirstName(newEmployee.getFirstName());
            employee.setLastName(newEmployee.getLastName());
            employee.setAge(newEmployee.getAge());
            employee.setSalary(newEmployee.getSalary());
            entityManager.getTransaction().commit();
            return "successfully updated";
        }catch (HibernateException e){
            return e.getMessage();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Employee> getAllEmployeesSortedBySalary() {
        List<Employee> employees = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            employees = entityManager.createQuery("select e from Employee e order by salary",Employee.class).getResultList();
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return employees;
    }
}
