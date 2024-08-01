package utcn.departmentManager.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentId(Integer departmentId);
    List<Employee> findByManagerId(Integer managerId);
    List<Employee> findByDepartmentIdAndManagerId(Integer departmentId, Integer managerId);
}
