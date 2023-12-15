package com.gambit.gameservice.mapper;

import com.gambit.game_service.model.UserDTO;
import com.gambit.gameservice.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO map(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setUserName(userEntity.getUserName());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setAvatarBase64(userEntity.getAvatarBase64());
        userDTO.setPasswordHash(userEntity.getPasswordHash());
        userDTO.setRating(userEntity.getRating());
        userDTO.setBalance(userEntity.getBalance());
        return userDTO;
    }
}
