package kg.megalab.demo.dal.entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import kg.megalab.demo.dal.dto.CommentDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name ="comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @Timestamp
    @Column(name = "written_at", nullable = false)
    private LocalDateTime writtenAt;

    @ManyToOne
    @JoinColumn(name = "idea_id", nullable = false)
    private IdeaEntity idea;


    public CommentEntity(CommentDto commentDto){
        this.id = commentDto.getId();
        this.text = commentDto.getText();
        this.writtenAt = LocalDateTime.now();
        this.idea = new IdeaEntity(commentDto.getIdeaId().getId());
    }

}
