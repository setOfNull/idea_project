package kg.megalab.demo.dal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kg.megalab.demo.dal.entity.IdeaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdeaDto {


    private Long id;

    @NotBlank(message = "text.not.empty")
    @Size(max = 200)
    private String text;

    private UserIdDto userId;

    private List<CommentDto> comments;

    private List<LikeDto> likes;



    public IdeaDto(IdeaEntity entity){
        this.id = entity.getId();
        this.text = entity.getText();
        this.userId = new UserIdDto(entity.getUser().getId());
        this.comments = entity.getComments().stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
        this.likes = entity.getLikes().stream()
                .map(LikeDto::new)
                .collect(Collectors.toList());
    }
}
/*
Я убрала из дто время, и оно перестало отображаться в постмане.
 */