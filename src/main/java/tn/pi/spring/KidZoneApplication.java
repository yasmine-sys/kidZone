package tn.pi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EntityScan( basePackages = {"tn.pi.spring.entity"})
@SpringBootApplication
public class KidZoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KidZoneApplication.class, args);
	}

}
