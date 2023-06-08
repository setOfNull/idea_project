package kg.megalab.demo.dal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserIdDto {
    private Long id;

    public UserIdDto(Long id){
        this.id = id;
    }
}
