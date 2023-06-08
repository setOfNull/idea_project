package kg.megalab.demo.dal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import kg.megalab.demo.dal.entity.CommentEntity;
import kg.megalab.demo.dal.entity.IdeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private String text;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime writtenAt;

    private IdeaIdDto ideaId;



    public CommentDto(CommentEntity comment){
        this.id = comment.getId();
        this.text = comment.getText();
        this.ideaId = new IdeaIdDto(comment.getIdea().getId());
        this.writtenAt = LocalDateTime.now();
    }
}
