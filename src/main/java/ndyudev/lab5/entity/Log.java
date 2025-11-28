package ndyudev.lab5.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="Lab5Log")
@Table(name = "Logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "Url", nullable = false)
    private String url;
    
    @Column(name = "Time")
    private LocalDateTime time = LocalDateTime.now(); 
    
    @Column(name = "Username")
    private String username;
    
    @ManyToOne
    @JoinColumn(name = "Username", insertable = false, updatable = false)
    private User user;
}