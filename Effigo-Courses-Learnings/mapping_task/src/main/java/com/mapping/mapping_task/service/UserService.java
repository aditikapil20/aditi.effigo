package com.mapping.mapping_task.service;
import com.mapping.mapping_task.dtos.UserRequestDto;
import com.mapping.mapping_task.dtos.UserResponseDto;
import com.mapping.mapping_task.entity.UserEntity;
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

    // Create or Update User
//    public UserEntity saveUser(UserEntity userEntity) {
//        return userRepository.save(userEntity);

        public UserEntity saveUser(UserRequestDto userRequestDto) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(userRequestDto.getUserId());
            userEntity.setAge(userRequestDto.getAge());
            userEntity.setName(userRequestDto.getName());


            return userRepository.save(userEntity);

    }

    public Optional<UserResponseDto> getUserById(String userId) {
        return userRepository.findById(userId)
                .map(user -> new UserResponseDto(user.getUserId(), user.getName(), user.getAge(), user));
    }


    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user.getUserId(), user.getName(), user.getAge(), user))
                .collect(Collectors.toList());
    }


    // Delete User by ID
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }

    // Update User
    public Optional<UserResponseDto> updateUser(String userId, UserRequestDto userRequestDto) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setName(userRequestDto.getName());
            existingUser.setAge(userRequestDto.getAge());

            UserEntity updatedUser = userRepository.save(existingUser);
            return new UserResponseDto(updatedUser.getUserId(), updatedUser.getName(), updatedUser.getAge(), updatedUser);
        });
    }

}
