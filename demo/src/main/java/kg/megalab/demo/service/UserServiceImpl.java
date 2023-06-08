package kg.megalab.demo.service;


import kg.megalab.demo.dal.dto.UserDto;
import kg.megalab.demo.dal.dto.UserSaveDto;
import kg.megalab.demo.dal.entity.UserEntity;
import kg.megalab.demo.dal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    public void saveUser(UserSaveDto user) {
        UserEntity entity = new UserEntity(user);
        userRepository.save(entity);
    }


    public List<UserDto> getAllUsers() {
        List<UserEntity> user = (List<UserEntity>)userRepository.findAll();
        return user.stream().map(UserDto::new)
                .collect(Collectors.toList());
    }

    public UserEntity getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("user.not.found"));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);

    }


    //!!!!ИЗМЕНИЛА!!!!!!!!!
    public void updateUser(Long id, UserDto dto){
        UserEntity user = userRepository.findById(dto.getId()).orElseThrow(RuntimeException::new);
        if (user != null){
            user.setEmail(dto.getEmail());
            user.setLogin(dto.getLogin());
            user.setFirstname(dto.getFirstname());
            user.setLastname(dto.getLastname());
            userRepository.save(user);
        }else {
            throw new RuntimeException("user.not.found");
        }
    }


}
