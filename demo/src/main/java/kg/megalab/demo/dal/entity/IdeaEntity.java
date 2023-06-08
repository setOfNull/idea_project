package kg.megalab.demo.dal.entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import kg.megalab.demo.dal.dto.IdeaDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "ideas")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @Column(name = "textt")
    private String text;

    @Timestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @OneToMany(mappedBy = "idea", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy = "idea", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<LikeEntity> likes;

    @Column(name = "is_actual")
    private Boolean isActual;

    public IdeaEntity(IdeaDto idea){
        this.id = idea.getId();
        this.text = idea.getText();
        this.createdAt = LocalDateTime.now();
        this.user = new UserEntity(idea.getUserId().getId());
    }

    public IdeaEntity(Long id) {
        this.id = id;
    }
}
