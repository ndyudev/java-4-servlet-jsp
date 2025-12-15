package ndyudev.asm.completed.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="EmployeeASM")
@Table(name = "employeess")
public class Employee {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private Double salary;
    @ManyToOne 
    @JoinColumn(name = "dp_id") 
    private Department department;

}