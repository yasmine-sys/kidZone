package tn.pi.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableJpaRepositories("healthchecker")
//@EnableWebMvc
@SpringBootApplication
public class PiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiApplication.class, args);
	}

}
