package ndyudev.lab4.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Lab4Video")
@Table(name = "Video")
@NamedQueries({
    @NamedQuery(
        name = "Video.findNoLike", 
        query = "SELECT v FROM Lab4Video v WHERE v.favorites IS EMPTY"
    )
})

@NamedNativeQueries({
	@NamedNativeQuery(
		name = "Video.findVideoByKeyWord",
		query = "SELECT v FROM Lab4Video v where v.title like :keyword",
		resultClass = Video.class
	)
})
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
    
    @ToString.Exclude
    @OneToMany(mappedBy = "video") 
    private List<Favorite> favorites;
}