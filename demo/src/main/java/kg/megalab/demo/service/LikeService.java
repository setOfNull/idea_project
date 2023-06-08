package kg.megalab.demo.service;


import kg.megalab.demo.dal.dto.IdeaDto;
import kg.megalab.demo.dal.dto.LikeDto;
import kg.megalab.demo.dal.entity.IdeaEntity;
import kg.megalab.demo.dal.entity.LikeEntity;
import kg.megalab.demo.dal.repository.IdeaRepository;
import kg.megalab.demo.dal.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final IdeaRepository ideaRepository;


    public LikeDto addLikeToIdea(Long ideaId){
        IdeaEntity idea = ideaRepository.findById(ideaId)
                .orElseThrow(() -> new NotFoundException("no.idea"));

        LikeEntity like = likeRepository.findByIdeaId(ideaId);

        if (like != null) {
            like.setLikeCount(like.getLikeCount() + 1);
        } else {
            like = new LikeEntity();
            like.setLikeCount(1);
            like.setIdea(idea);
        }

        LikeEntity savedLike = likeRepository.save(like);

        return new LikeDto(savedLike);
    }


    public LikeDto deleteIdeaLikes(Long ideaId) {
        IdeaEntity idea = ideaRepository.findById(ideaId)
                .orElseThrow(() -> new NotFoundException("no.idea"));

        List<LikeEntity> likesToDelete = likeRepository.findByIdea(idea);
        likeRepository.deleteAll(likesToDelete);

        return new LikeDto();
    }
}