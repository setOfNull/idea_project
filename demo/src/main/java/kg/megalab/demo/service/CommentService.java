package kg.megalab.demo.service;


import kg.megalab.demo.dal.dto.CommentDto;
import kg.megalab.demo.dal.entity.CommentEntity;
import kg.megalab.demo.dal.entity.IdeaEntity;
import kg.megalab.demo.dal.repository.CommentRepository;
import kg.megalab.demo.dal.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final IdeaRepository ideaRepository;

    public void writeComment(CommentDto comment){
        CommentEntity entity = new CommentEntity(comment);
        commentRepository.save(entity);
    }

    public List<CommentDto> getAllComments(Long id){
        List<CommentEntity> comment = commentRepository.findByIdeaId(id);

        return comment.stream().map(CommentDto::new).collect(Collectors.toList());
    }

    public CommentDto deleteIdeaComment(Long ideaId){
        IdeaEntity idea = ideaRepository.findById(ideaId)
                .orElseThrow(()-> new NotFoundException("no.idea"));

        List<CommentEntity> comments = commentRepository.findByIdeaId(ideaId);
        commentRepository.deleteAll(comments);
        return new CommentDto();
    }
}
