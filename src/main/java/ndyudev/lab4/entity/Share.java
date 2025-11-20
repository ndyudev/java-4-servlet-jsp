package ndyudev.lab4.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Lab4Share")
@Table(name = "Share")
@NamedQueries({
		@NamedQuery(
				name = "Share.VideoShareIn2024", 
				query = "SELECT s FROM Lab4Share s WHERE year(s.shareDate) = 2024"
						+ " ORDER BY s.shareDate DESC") })
public class Share {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "UserId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "VideoId")
	private Video video;

	@Column(name = "Emails", columnDefinition = "nvarchar(255)")
	private String emails;

	@Column(name = "ShareDate")
	@Temporal(TemporalType.DATE)
	private Date shareDate;
}
