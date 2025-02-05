package com.effigocourse.newproject;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class NewprojectApplication {

	public static void main(String[] args) {

		SpringApplication.run(NewprojectApplication.class, args);
		int id;
		String name;
		String email;
		String gender;

	}

}
