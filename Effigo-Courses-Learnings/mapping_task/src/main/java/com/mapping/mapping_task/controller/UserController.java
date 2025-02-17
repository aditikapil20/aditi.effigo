package com.mapping.mapping_task.controller;

import com.mapping.mapping_task.dtos.UserRequestDto;
import com.mapping.mapping_task.dtos.UserResponseDto;
import com.mapping.mapping_task.entity.UserEntity;
import com.mapping.mapping_task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto savedUser = userService.saveUser(userRequestDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetch-by-id/{userId}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String userId) {
        Optional<UserResponseDto> userResponse = userService.getUserById(userId);
        return userResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/fetch-all-users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto) {
        Optional<UserResponseDto> updatedUser = userService.updateUser(userId, userRequestDto);
        return updatedUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}