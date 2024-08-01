package utcn.departmentManager.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {

        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found with id: " + id));
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department existingDepartment = getDepartmentById(id);
        existingDepartment.setDescription(updatedDepartment.getDescription());
        existingDepartment.setParent(updatedDepartment.getParent());
        return departmentRepository.save(existingDepartment);
    }
}
