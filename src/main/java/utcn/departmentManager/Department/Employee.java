package utcn.departmentManager.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Employee {
    @Id
    Integer id;

    String name;

    Integer departmentId;

    Integer managerId;

    String email;

    public Employee(Integer id, String name, Integer departmentId, Integer managerId, String email){
        this.id = id;
        this.name = name;
        this.departmentId = departmentId;
        this.managerId = managerId;
        this.email = email;
    }
}
