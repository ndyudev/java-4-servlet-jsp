package ndyudev.lab4.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Lab4Favorite")
@Table(name = "Favorite")
public class Favorite {
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

    @Temporal(TemporalType.DATE)
    @Column(name = "LikeDate")
    private Date likeDate;
}