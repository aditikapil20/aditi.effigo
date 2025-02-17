package com.mapping.mapping_task.service;
import com.mapping.mapping_task.dtos.UserRequestDto;
import com.mapping.mapping_task.dtos.UserResponseDto;
import com.mapping.mapping_task.entity.UserEntity;
import com.mapping.mapping_task.mappers.UserMapper;
import com.mapping.mapping_task.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper; // Injecting Mapper

    // Create or Update User
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = userMapper.toEntity(userRequestDto); // Using Mapper
        UserEntity savedUser = userRepository.save(userEntity);
        return userMapper.toDto(savedUser); // Converting back to DTO
    }

    public Optional<UserResponseDto> getUserById(String userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDto); // Using Mapper
    }

    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto) // Using Mapper
                .collect(Collectors.toList());
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    public Optional<UserResponseDto> updateUser(String userId, UserRequestDto userRequestDto) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setName(userRequestDto.getName());
            existingUser.setAge(userRequestDto.getAge());

            UserEntity updatedUser = userRepository.save(existingUser);
            return userMapper.toDto(updatedUser); // Using Mapper
        });
    }
}