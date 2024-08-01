package utcn.departmentManager.Department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) throws Exception{
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found with id:"+id));
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setDepartmentId(updatedEmployee.getDepartmentId());
        existingEmployee.setManagerId(updatedEmployee.getManagerId());

        return employeeRepository.save(existingEmployee);
    }

    public List<Employee> getAllEmployeePerDepartment(Integer departmentId){
        return employeeRepository.findByDepartmentId(departmentId);
    }

    public List<Employee> getEmployeesByDepartmentAndManager(Integer departmentId, Integer managerId) {
        return employeeRepository.findByDepartmentIdAndManagerId(departmentId, managerId);
    }
}
