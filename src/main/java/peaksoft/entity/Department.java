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
@ToString
public class Department {
    @Id
    @GeneratedValue(generator = "department_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "department_gen", sequenceName = "department_seq")
    private Long id;
    private String departmentName;
    private int maxEmployeeNumber;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}
