package peaksoft.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Department {
    @Id
    @GeneratedValue(generator = "department_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq")
    private Long id;
    private String departmentName;
    private int maxEmployeeNumber;
    @OneToMany(mappedBy = "department",fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
    private List<Employee> employees;

    public Department(String departmentName, int maxEmployeeNumber) {
        this.departmentName = departmentName;
        this.maxEmployeeNumber = maxEmployeeNumber;
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", maxEmployeeNumber=" + maxEmployeeNumber +
                ", employees=" + employees +
                '}';
    }
}
