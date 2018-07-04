package com.kshrd.ams.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()                                  
		        .apis(RequestHandlerSelectors.basePackage("com.kshrd.ams.rest"))              
		        .paths(PathSelectors.any())                          
		        .build()
		        .apiInfo(this.apiInfo()); 
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfo("SR AMS_API Documentation",
						   "API for developer",
						   "1.0",
						   "http://www.kshrd.com.kh",
						   "Siem Reap Class",
						   "http://www.kshrd.com.kh", 
						   "http://www.kshrd.com.kh");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/swagger").setViewName("swagger/index");
	}
	
	
}







