package kg.megalab.demo.controller;

import jakarta.validation.Valid;
import kg.megalab.demo.dal.dto.UserDto;
import kg.megalab.demo.dal.dto.UserSaveDto;
import kg.megalab.demo.dal.entity.UserEntity;
import kg.megalab.demo.service.IdeaServiceImpl;
import kg.megalab.demo.service.UserService;
import kg.megalab.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<?> saveUsers(@Valid @RequestBody UserSaveDto body){
        userService.saveUser(body);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@Valid @PathVariable("id") Long id){
        UserEntity user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK );
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@Valid @RequestParam("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto body, @RequestParam("id") Long id){
        userService.updateUser(id, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
