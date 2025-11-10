package ndyudev.lab2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Lab2User")
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "id")
	String id;

	@Column(name = "password")
	String password;

	@Column(name = "fullname", columnDefinition = "nvarchar(50)")
	String fullname;

	@Column(name = "email")
	String email;

	@Column(name = "admin")
	Boolean admin = false;
}
