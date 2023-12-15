package com.gambit.gameservice.service;

import com.gambit.game_service.model.UserDTO;
import com.gambit.game_service.model.UserListDTO;
import com.gambit.gameservice.entity.UserEntity;
import com.gambit.gameservice.mapper.UserMapper;
import com.gambit.gameservice.repository.UserRepository;
import com.gambit.gameservice.utils.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        EmailValidator.validate(userDTO.getEmail());
        UserEntity userEntity = createUserEntity(userDTO);
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return userMapper.map(createdUserEntity);
    }

    public UserDTO updateUser(UserDTO userDTO) {
        EmailValidator.validate(userDTO.getEmail());
        UserEntity userEntity = createUserEntity(userDTO);
        userEntity.setId(userDTO.getId());
        UserEntity updatedUserEntity = userRepository.save(userEntity);
        return userMapper.map(updatedUserEntity);
    }

    @Transactional
    public void deleteUser(String id) {
        UUID userId = UUID.fromString(id);
        if (!userRepository.existsById(userId)) {
            throw new IllegalStateException("User with id = [" + id + "] not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional(readOnly = true)
    public UserListDTO getUserList() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> users = userEntities
                .stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
        UserListDTO userListDTO = new UserListDTO();
        userListDTO.setUsers(users);
        return userListDTO;
    }

    private UserEntity createUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setAvatarBase64(userDTO.getAvatarBase64());
        userEntity.setPasswordHash(userDTO.getPasswordHash());
        userEntity.setRating(userDTO.getRating());
        userEntity.setBalance(userDTO.getBalance());
        return userEntity;
    }

    private UserEntity updateUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setAvatarBase64(userDTO.getAvatarBase64());
        userEntity.setPasswordHash(userDTO.getPasswordHash());
        userEntity.setRating(userDTO.getRating());
        userEntity.setBalance(userDTO.getBalance());
        return userEntity;
    }
}
