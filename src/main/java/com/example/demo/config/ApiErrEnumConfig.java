package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.errcode.ApiErrCodeEnumMap;

@Configuration
public class ApiErrEnumConfig {
	@Bean
	public ApiErrCodeEnumMap apiErrCode() {
		return new ApiErrCodeEnumMap();
	}
}
