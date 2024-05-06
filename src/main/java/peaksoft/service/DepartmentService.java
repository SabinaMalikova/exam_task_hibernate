package peaksoft.service;

import peaksoft.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    //CRUD
    String saveDepartment(Department department);
    Optional<Department> getDepartmentById(Long departmentId);
    List<Department> getAllDepartments();
    String updateDepartment (Long oldDepartmentId, Department newDepartment);

    String deleteDepartment(Long id);

}
