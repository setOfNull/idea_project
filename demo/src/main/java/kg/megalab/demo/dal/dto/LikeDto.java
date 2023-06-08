package kg.megalab.demo.dal.dto;


import kg.megalab.demo.dal.entity.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private int likeCount;


    public LikeDto(LikeEntity like){
        this.likeCount = like.getLikeCount();
    }
}
