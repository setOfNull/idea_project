package kg.megalab.demo.service;

import kg.megalab.demo.dal.dto.IdeaDto;
import java.util.List;

public interface IdeaService {
     void saveIdea(IdeaDto idea);

    List<IdeaDto> getAllIdeas();

    void deleteIdea(Long ideaId);

    void updateIdea(Long id, IdeaDto ideaDto);

    List<IdeaDto> getUserIdeas(Long userId);
}
