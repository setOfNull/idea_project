package kg.megalab.demo.controller;


import kg.megalab.demo.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?> addLike(@RequestParam("id") Long id){
        likeService.addLikeToIdea(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteLike(@RequestParam("id") Long id){
        likeService.deleteIdeaLikes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
