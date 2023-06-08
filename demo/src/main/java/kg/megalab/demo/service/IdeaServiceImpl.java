package kg.megalab.demo.service;

import kg.megalab.demo.dal.dto.IdeaDto;
import kg.megalab.demo.dal.entity.IdeaEntity;
import kg.megalab.demo.dal.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class IdeaServiceImpl implements IdeaService{
    private final IdeaRepository ideaRepository;

    public void saveIdea(IdeaDto idea) {
        IdeaEntity entity = new IdeaEntity(idea);
        ideaRepository.save(entity);
    }


    public List<IdeaDto> getAllIdeas() {
        List<IdeaEntity> idea = (List<IdeaEntity>) ideaRepository.findAll();
        return idea.stream().map(IdeaDto::new).collect(Collectors.toList());
    }


    public void deleteIdea(Long ideaId){
        if (!ideaRepository.existsById(ideaId)){
        throw new RuntimeException("no.idea");
    }
        ideaRepository.deleteById(ideaId);
    }

public void updateIdea(Long id, IdeaDto ideaDto){
        Optional<IdeaEntity> ideaEntity = ideaRepository.findById(id);
        if (ideaEntity.isPresent()){
            IdeaEntity entity = ideaEntity.get();
            entity.setText(ideaDto.getText());
            ideaRepository.save(entity);
        }else{
            throw new RuntimeException("no.idea");
        }
}

    public List<IdeaDto> getUserIdeas(Long userId) {
        List<IdeaEntity> userIdeas = ideaRepository.findByUserId(userId);
        if (!ideaRepository.existsById(userId)){
            throw new RuntimeException("user.not.found");
        }
        return userIdeas.stream()
                .map(IdeaDto::new)
                .collect(Collectors.toList());
    }


    public void updateIsActualStatus() {
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        ideaRepository.updateIsActualStatus(sevenDaysAgo);
    }
}