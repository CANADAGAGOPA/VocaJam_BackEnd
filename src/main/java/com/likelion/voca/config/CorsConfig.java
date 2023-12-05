package com.likelion.voca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 해당 클래스가 Spring 의 설정 클래스임을 나타낸다.
@EnableWebMvc // Spring MVC 를 사용
public class CorsConfig implements WebMvcConfigurer { // CORS 를 구성하기 위한 설정 클래스

    @Bean // corsConfigurer 메서드를 빈으로 등록
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/words/**")
                        .allowedOrigins("http://localhost:3000") // 프론트엔드 서버 주소
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드를 설정
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .maxAge(3600);
            }
        };
    }
}
