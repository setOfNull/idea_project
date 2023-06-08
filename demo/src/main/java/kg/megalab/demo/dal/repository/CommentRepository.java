package kg.megalab.demo.dal.repository;
import kg.megalab.demo.dal.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findByIdeaId(Long id);
}
