package com.navitas.upload.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import com.navitas.upload.data.repository.rfdsRepository;




@Configuration
@EnableWebMvc
@EnableScheduling
@EnableAutoConfiguration
//@EntityScan("com.navitas.upload.data.entity")
@EnableJpaRepositories(basePackages = {"com.navitas.upload.data.repository"} )
@EntityScan( basePackages = {"com.navitas.upload.data.entity"} )
@ComponentScan({ "fileupload", "com.navitas.upload.controller" })
@PropertySource("classpath:application.properties")
public class AppConfig extends WebMvcConfigurerAdapter
{
	public static final int UPLOAD_SIZE = 10000000;
	
	 
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver()
	{
	  CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	  multipartResolver.setMaxUploadSize( UPLOAD_SIZE );
	  return new CommonsMultipartResolver();
	}
	
	
	
}

