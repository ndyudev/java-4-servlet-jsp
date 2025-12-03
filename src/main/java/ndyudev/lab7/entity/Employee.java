package ndyudev.lab7.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employees")
@Entity
public class Employee {
	@Id
	@Column(name="Id")
	private String id;
	@Column(name="Fullname")
	private String fullname;
	@Column(name="Gender")
	private Boolean gender;
	@Column(name="Salary")
	private Double salary;
}
