package kg.megalab.demo.dal.repository;

import kg.megalab.demo.dal.entity.IdeaEntity;
import kg.megalab.demo.dal.entity.LikeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<LikeEntity, Long> {
    LikeEntity findByIdeaId(Long ideaId);

    List<LikeEntity> findByIdea(IdeaEntity idea);
}
