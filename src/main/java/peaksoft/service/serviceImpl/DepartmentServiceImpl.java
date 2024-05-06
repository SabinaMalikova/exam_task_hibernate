package peaksoft.service.serviceImpl;

import peaksoft.dao.DepartmentDao;
import peaksoft.dao.daoImpl.DepartmentDaoImpl;
import peaksoft.entity.Department;
import peaksoft.service.DepartmentService;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public String saveDepartment(Department department) {
        return departmentDao.saveDepartment(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    @Override
    public String updateDepartment(Long oldDepartmentId, Department newDepartment) {
        return departmentDao.updateDepartment(oldDepartmentId,newDepartment);
    }

    @Override
    public String deleteDepartment(Long id) {
        return departmentDao.deleteDepartment(id);
    }


}
