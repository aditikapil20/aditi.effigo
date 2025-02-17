package com.mapping.mapping_task.mappers;

import com.mapping.mapping_task.dtos.TransRequestDto;
import com.mapping.mapping_task.dtos.TransResponseDto;
import com.mapping.mapping_task.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "transactionId", target = "transactionId")
    @Mapping(source = "transactionType", target = "transactionType")
    @Mapping(source = "transactionAmount", target = "transactionAmount")
    TransactionEntity toEntity(TransRequestDto transRequestDto);

    @Mapping(source = "transactionId", target = "transactionId")
    @Mapping(source = "transactionType", target = "transactionType")
    @Mapping(source = "transactionAmount", target = "transactionAmount")
    TransResponseDto toDto(TransactionEntity transactionEntity);
}
