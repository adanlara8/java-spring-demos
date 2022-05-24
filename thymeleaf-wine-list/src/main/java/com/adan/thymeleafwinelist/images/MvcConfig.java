package com.adan.thymeleafwinelist.images;



import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		Path  wineUploadDir = Paths.get("./wine-pictures");
		String wineUploadPath = wineUploadDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/wine-pictures/**").addResourceLocations("file:/" + wineUploadPath +"/");
		
	}

	

	
	
}
