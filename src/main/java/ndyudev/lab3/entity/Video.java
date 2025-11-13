package ndyudev.lab3.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "Lab3Video")
@Table(name = "Video")
public class Video {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Title", columnDefinition = "nvarchar(200)")
    private String title;

    @Column(name = "Poster", columnDefinition = "nvarchar(255)")
    private String poster;

    @Column(name = "Views")
    private Integer views;

    @Column(name = "Description", columnDefinition = "nvarchar(max)")
    private String description;

    @Column(name = "Active")
    private Boolean active;
}
