package com.mapping.mapping_task.mappers;

import com.mapping.mapping_task.dtos.UserRequestDto;
import com.mapping.mapping_task.dtos.UserResponseDto;
import com.mapping.mapping_task.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapping from UserRequestDto to UserEntity
    @Mapping(target = "bankAccountEntity", ignore = true)  // Ignoring bankAccountEntity for now
    UserEntity toEntity(UserRequestDto userRequestDto);

    // Mapping from UserEntity to UserResponseDto
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(target = "userEntity", ignore = true) // Prevent recursion issues
    UserResponseDto toDto(UserEntity userEntity);
}

