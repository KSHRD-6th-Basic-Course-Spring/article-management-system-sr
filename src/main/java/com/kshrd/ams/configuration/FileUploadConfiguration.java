package com.kshrd.ams.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@PropertySource("classpath:ams.properties")
public class FileUploadConfiguration extends WebMvcConfigurerAdapter {
	
	@Value("${file.upload.client.path}")
	String clientPath;
	@Value("${file.upload.server.path}")
	String serverPath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(clientPath + "**").addResourceLocations("file:" + serverPath);
	}
	
}
