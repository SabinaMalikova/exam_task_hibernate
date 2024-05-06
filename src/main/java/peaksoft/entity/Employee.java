package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    @Id
    @GeneratedValue(generator = "employee_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_gen", sequenceName = "employee_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private double salary;
    @ManyToOne(cascade = CascadeType.DETACH,fetch=FetchType.EAGER)
    private Department department;

    public Employee(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}
