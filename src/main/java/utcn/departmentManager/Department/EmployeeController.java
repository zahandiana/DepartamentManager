package utcn.departmentManager.Department;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
//@ComponentScan(basePackages = {"com.gi.controller"})

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/createEmployee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) throws Exception{
        Employee result = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/employee/department/{departmentId}")
    public List<Employee> getAllEmployeePerDepartment(@PathVariable Integer departmentId){
        return employeeService.getAllEmployeePerDepartment(departmentId);
    }

    @GetMapping("/employee/department/{departmentId}/manager/{managerId}")
    public List<Employee> getEmployeesByDepartmentAndManager(@PathVariable Integer departmentId, @PathVariable Integer managerId) {
        return employeeService.getEmployeesByDepartmentAndManager(departmentId, managerId);
    }
}
