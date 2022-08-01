package com.ftr.terminal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FtrTerminalsApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(FtrTerminalsApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("/**").allowedMethods("GET","POST","PUT","DELETE");
	}
	
	   @Bean
	   public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	      messageSource.setBasename("classpath:ValidationMessages");
	      messageSource.setDefaultEncoding("UTF-8");
	      return messageSource;
	   }
	   
	   @Bean
	   public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	      LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	      bean.setValidationMessageSource(messageSource);
	      return bean;
	   }
}
