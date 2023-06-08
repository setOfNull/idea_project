package kg.megalab.demo.service;

import kg.megalab.demo.dal.dto.UserDto;
import kg.megalab.demo.dal.dto.UserSaveDto;
import kg.megalab.demo.dal.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void saveUser(UserSaveDto user);

    List<UserDto> getAllUsers();

    UserEntity getUserById(Long id);

    void updateUser(Long id, UserDto dto);

    void deleteUser(Long id);
}
