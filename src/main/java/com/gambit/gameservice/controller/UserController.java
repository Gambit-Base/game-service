package com.gambit.gameservice.controller;


import com.gambit.game_service.api.UserApi;
import com.gambit.game_service.model.UserDTO;
import com.gambit.game_service.model.UserListDTO;
import com.gambit.gameservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUser(String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserListDTO> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }
}
