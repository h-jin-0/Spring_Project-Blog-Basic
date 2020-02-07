package com.hj.springBlog.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import com.hj.springBlog.aop.SessionIntercepter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	//얘가 web.xml이다 
	
	@Value("${file.path}")
	private String fileRealPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		
		//파일 경로 인식하게 하기
		registry.addResourceHandler("/media/**")
		.addResourceLocations("file:///"+fileRealPath)
		.setCachePeriod(3600)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())//이렇게 하면 내가 인터셉터를 만들 수 있다.//들어간 그 함수의 직전, 직후, 둘다 이렇게 설정도 할 수 있다.
			.addPathPatterns("/user/profile/**")//이 주소로 들어오면 이 클래스(세션인터셉터)를 호출할꺼다는 뜻
			.addPathPatterns("/post/write/**")
			.addPathPatterns("/post/update/**")
			.addPathPatterns("/post/delete/**");
	}
}
