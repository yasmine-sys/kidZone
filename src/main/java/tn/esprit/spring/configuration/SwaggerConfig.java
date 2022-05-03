package tn.esprit.spring.configuration;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//Initialiser une classe de ApiSelectorBuilder pour donner l’accès aux méthodes de personnalisation.

				//.apis(RequestHandlerSelectors.any()) //any: documenter toutes les classes dans tous les   packages
				.apis(RequestHandlerSelectors.basePackage("tn.esprit.spring")) 
				// basePackage permet de demander à Swagger de ne rien documenter en dehors du package "com.esprit.spring".

				.paths(PathSelectors.any())
				//.paths(PathSelectors.regex("/SpringMVC/client.*")) // accepte seulement les URIs qui commençent par /client. 

				.build().apiInfo(apiInfo());//Informations personnalisées
				//.build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger Configuration for tpAchat")
				.description("\"Spring Boot Swagger configuration\"")
				.version("1.1.0")
				.build();
	}


}
