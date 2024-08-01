package utcn.departmentManager.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Department {
    @Id
    Integer id;

    String description;

    @ManyToOne
    Department parent;

    public Department(Integer id, String description){
        this.id = id;
        this.description = description;
    }

    public Department(Integer id, String description, Department parent){
        this.id = id;
        this.description = description;
        this.parent = parent;
    }
}
