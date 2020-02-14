package com.hj.springBlog.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hj.springBlog.model.RespCM;
import com.hj.springBlog.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 진입되기 직전에 메모리에 띄울 것 이다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder encoded() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private MyUserDetailService myUserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception { // 모든 요청을 받는다.
		http.csrf().disable();

		http.authorizeRequests()
				.antMatchers("/user/profile/**", "/post/write/**", "/post/update/**", "/post/delete/**",
						"/post/detail/**")
				.authenticated().antMatchers("/amdin/**").access("hasRole('ROLE_ADMIN')or hasRole('ROLE_MANAGER')")// 권한
																													// //
																													// 해준다.
				.anyRequest().permitAll().and() // 안드로이드 앱 같은 경우는 폼 로그인이 아니다. 웹에서는 폼 로그인방식을 많이 쓴다.
				.formLogin().loginPage("/user/login") // 그냥 주소로 가고싶으면 defaultSuccessUrl()로 가면 되고, 그 전에 무언갈
														// 수행하고싶으면successHandler을 사용하여 new 할수 있다.
				.loginProcessingUrl("/user/login") // POST만 낚아 챔
				.successHandler(new AuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						PrintWriter out = response.getWriter();
						
						ObjectMapper mapper = new ObjectMapper();

						// String으로 저장
						String jsonString = mapper.writeValueAsString(new RespCM(200, "ok"));
						out.print(jsonString);
						out.flush();

					}
				});// defaultSuccessUrl을 사용 가능
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailService).passwordEncoder(encoded());
	}
}