package kg.megalab.demo.controller;


import kg.megalab.demo.dal.dto.CommentDto;
import kg.megalab.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> writeComment(@RequestBody CommentDto commentDto){
        commentService.writeComment(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getComments(@RequestParam("id") Long id){
        return new ResponseEntity<>(commentService.getAllComments(id), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteIdeaComments(@RequestParam("id") Long id){
        commentService.deleteIdeaComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
