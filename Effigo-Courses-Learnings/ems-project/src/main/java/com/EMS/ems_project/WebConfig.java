package com.EMS.ems_project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // APIs allowed
                        .allowedOrigins("http://localhost:3000") // React frontend allowed
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed Methods
                        .allowedHeaders("*") // All Headers Allowed
                        .allowCredentials(true);
            }
        };
    }
}

