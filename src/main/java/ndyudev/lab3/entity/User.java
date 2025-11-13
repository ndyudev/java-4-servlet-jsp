package ndyudev.lab3.entity;

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

@Entity(name="Lab3User")
@Table(name="Users")
public class User {
	@Id
	@Column(name="id")
	private String id;
	@Column(name="Fullname", columnDefinition = "nvarchar(50)")
	private String fullName;
	@Column(name="password")
	private String password;
	@Column(name="email")
	private String email;
	@Column(name = "admin")
	private Boolean admin;
}
