package peaksoft.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConfig;
import peaksoft.dao.DepartmentDao;
import peaksoft.entity.Department;
import peaksoft.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.find;

public class DepartmentDaoImpl implements DepartmentDao {
    private final EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();
    @Override
    public String saveDepartment(Department department) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(department);
            entityManager.getTransaction().commit();
            return "successfully saved";
        }catch (HibernateException e){
            return e.getMessage();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Department department = null;
        try{
            entityManager.getTransaction().begin();
            department = entityManager.find(Department.class, departmentId);
            entityManager.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return Optional.ofNullable(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            departments = entityManager.createQuery("select d from Department d",Department.class).getResultList();
            entityManager.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return departments;
    }

    @Override
    public String updateDepartment(Long oldDepartmentId, Department newDepartment) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Department department = entityManager.find(Department.class, oldDepartmentId);
            department.setDepartmentName(newDepartment.getDepartmentName());
            department.setMaxEmployeeNumber(newDepartment.getMaxEmployeeNumber());
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
    public String deleteDepartment(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Department department = entityManager.find(Department.class, id);
            for (Employee employee : department.getEmployees()) {
                employee.setDepartment(null);
            }
            department.setEmployees(null);
            entityManager.remove(department);
            entityManager.getTransaction().commit();
        }catch (HibernateException e){
            return e.getMessage();
        }finally {
            entityManager.close();
        }
        return "successfully deleted";
    }
}
