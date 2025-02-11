package com.mapping.mapping_task.dtos;
import lombok.*;

@Data
@NoArgsConstructor        // Generates a no-argument constructor.
@AllArgsConstructor       // Generates a constructor with all fields.


public class UserRequestDto {
    private String userId;
    private String name;
    private int age;
}

