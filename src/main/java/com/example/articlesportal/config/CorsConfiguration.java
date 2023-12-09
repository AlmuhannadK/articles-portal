package com.example.articlesportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
//public class CorsConfiguration{
//
//    @Bean
//    public WebMvcConfigurer corsConfig() {
//        String[] allowDomains = new String[2];
//        allowDomains[0] = "http://localhost:4200";
//        allowDomains[1] = "http://localhost:8080";
//        //System.out.println("CORS configuration....");
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins(allowDomains)
//                        .allowedHeaders("*")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE")
//                        .allowCredentials(true);
//            }
//        };
//    }
//}