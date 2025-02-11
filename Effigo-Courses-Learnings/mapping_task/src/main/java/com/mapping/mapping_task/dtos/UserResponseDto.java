package com.mapping.mapping_task.dtos;

import com.mapping.mapping_task.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String userId;
    private String name;
    private int age;

    private UserEntity userEntity;
    public UserResponseDto(UserEntity userEntity)
    {
        this.userEntity = userEntity;
    }

}
