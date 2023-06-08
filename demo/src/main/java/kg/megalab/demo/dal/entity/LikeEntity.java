package kg.megalab.demo.dal.entity;


import jakarta.persistence.*;
import kg.megalab.demo.dal.dto.LikeDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "likes")
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    private int likeCount;

    @ManyToOne
    @JoinColumn(name = "idea_id", nullable = false)
    private IdeaEntity idea;

    public LikeEntity(LikeDto like){
        this.likeCount = like.getLikeCount();
    }
}
