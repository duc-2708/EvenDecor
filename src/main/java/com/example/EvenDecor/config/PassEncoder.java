package com.example.EvenDecor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class PassEncoder {
	@Bean
	public PasswordEncoder passWordEncoder() {
		return new BCryptPasswordEncoder();
	} // ma hóa pass
}
