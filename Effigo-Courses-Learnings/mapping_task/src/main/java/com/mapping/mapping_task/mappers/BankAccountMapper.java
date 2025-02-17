package com.mapping.mapping_task.mappers;

import com.mapping.mapping_task.dtos.BankRequestDto;
import com.mapping.mapping_task.dtos.BankResponseDto;
import com.mapping.mapping_task.entity.BankAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    BankAccountMapper INSTANCE = Mappers.getMapper(BankAccountMapper.class);

    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "accountHolderName", target = "accountHolderName")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "balance", target = "balance")
    BankAccountEntity toEntity(BankRequestDto bankRequestDto);

    @Mapping(source = "accountId", target = "accountId")
    @Mapping(source = "accountHolderName", target = "accountHolderName")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "balance", target = "balance")
    BankResponseDto toDto(BankAccountEntity bankAccountEntity);
}





