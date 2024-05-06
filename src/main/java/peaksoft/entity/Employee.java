package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @GeneratedValue(generator = "employee_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    @ManyToOne
    private Department department;


}
