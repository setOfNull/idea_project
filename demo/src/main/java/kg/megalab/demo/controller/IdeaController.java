package kg.megalab.demo.controller;

import jakarta.validation.Valid;
import kg.megalab.demo.dal.dto.IdeaDto;
import kg.megalab.demo.service.IdeaServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ideas")
public class IdeaController {
    private final IdeaServiceImpl ideaService;

    @PostMapping
    public ResponseEntity<?> saveIdeas(@Valid @RequestBody IdeaDto idea){
        ideaService.saveIdea(idea);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//        @GetMapping
//        public ResponseEntity<?> getAllIdeas(){
//            return new ResponseEntity<>(ideaService.getAllIdeas(), HttpStatus.OK);
//    }


    @DeleteMapping
    public ResponseEntity<?> deleteIdea(@Valid @RequestParam("id") Long id){
        ideaService.deleteIdea(id);
        return null;
    }

    @PutMapping
    public ResponseEntity<?> updateIdea(@Valid @RequestBody IdeaDto ideaDto, @RequestParam("id") Long id){
        ideaService.updateIdea(id, ideaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllIdeasByUserId(@Valid @RequestParam("id") Long id){
        return  new ResponseEntity<>(ideaService.getUserIdeas(id), HttpStatus.OK);
    }


    @PutMapping("/{is_actual}")
    public ResponseEntity<?> updateIsActualStatus(){
        ideaService.updateIsActualStatus();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
