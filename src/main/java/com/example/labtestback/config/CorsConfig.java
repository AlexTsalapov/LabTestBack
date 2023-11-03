package com.example.labtestback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Разрешенный домен вашего фронтенда
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE", "HEAD")
                .allowedHeaders("Authorization", "Content-Type")
                .allowCredentials(true);
    }
}
