package kg.megalab.demo.dal.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IdeaIdDto {
    private Long id;

    public IdeaIdDto(Long id){
        this.id = id;
    }
}
