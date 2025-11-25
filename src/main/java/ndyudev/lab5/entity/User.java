package ndyudev.lab5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Users")
@Entity(name="Lab5User")
public class User {
	@Id
	@Column(name="Id")
	private String id;
	@Column(name="Fullname")
	private String fullName;
	@Column(name="Password")
	private String password;
	@Column(name="Email")
	private String email;
	@Column(name="Admin")
	private Boolean admin;
}
