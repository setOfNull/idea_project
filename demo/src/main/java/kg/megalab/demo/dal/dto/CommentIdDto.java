package kg.megalab.demo.dal.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentIdDto {

    private Long id;

    public CommentIdDto(Long id){
        this.id = id;
    }
}
