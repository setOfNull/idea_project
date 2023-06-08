package kg.megalab.demo.dal.repository;

import kg.megalab.demo.dal.entity.IdeaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IdeaRepository extends CrudRepository<IdeaEntity, Long> {
    List<IdeaEntity> findByUserId(Long userId);

//    @Query("select i from public.ideas i where i.is_actual = true ")
//    public void change(){
//
//    }

    @Query("update IdeaEntity i set i.isActual = false where i.lastActivity < :sevenDaysAgo")
    void updateIsActualStatus(LocalDate sevenDaysAgo);
}

//starter-web это для контроллерров
//рест и обычный контроллер
