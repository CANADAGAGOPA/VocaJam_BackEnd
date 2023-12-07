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

// CORS 구성은 /words/** 패턴의 URI에 대해서 특정 오리진에서 오는 요청을 허용하고,
// 특정 메서드 및 헤더 등에 대한 제한을 설정하는 역할

// CORS(Cross-Origin Resource Sharing)를 구성하기 위한 설정 클래스
// 다른 도메인에서 리소스 요청이 올 때 브라우저에서 보안 상의 이유로 차단되는 문제를 해결하기 위한 메커니즘