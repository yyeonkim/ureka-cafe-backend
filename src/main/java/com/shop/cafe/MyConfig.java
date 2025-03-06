package com.shop.cafe;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://127.0.0.1:5500") // 특정 Origin 허용
		.allowedMethods("*") // 모든 HTTP 메소드 허용
		.allowedHeaders("*") // 모든 헤더 허용
		.allowCredentials(true); // 쿠키, 세션 정보도 허용
	}
}
