package tn.pi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@EnableWebMvc
@EntityScan( basePackages = {"tn.pi.spring.entity"})
@SpringBootApplication
public class PiApplication implements  WebMvcConfigurer  {

	public void addViewController(ViewControllerRegistry registry)
	{
		registry.addViewController("/index").setViewName("index");
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(PiApplication .class, args);
		
	}
}


