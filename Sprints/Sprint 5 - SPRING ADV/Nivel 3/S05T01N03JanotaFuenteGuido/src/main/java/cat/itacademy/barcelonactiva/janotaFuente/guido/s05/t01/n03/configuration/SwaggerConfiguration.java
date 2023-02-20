package cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

 @Bean
 public Docket api() {
	 
     return new Docket(DocumentationType.SWAGGER_2)
             .select()
             .apis(RequestHandlerSelectors.basePackage("cat.itacademy.barcelonactiva.janotaFuente.guido.s05.t01.n03"))
             .paths(PathSelectors.any())
             .build()
             .apiInfo(getApiInfo());
     }   
 
 
 // Acá se cargan datos de la API que se visualizan en el index de la SwaggerUI
 private ApiInfo getApiInfo() {
     return new ApiInfo(
             "API Conectada a la API de Gestión de Flores del N2",
             "API-N3 to API-N2 Documentation",
             "1.0",
             "https://gj.com/",
             new Contact("Guido Janota", "https://gj.com", "guido@gmail.com"),
             "LICENSE",
             "LICENSE URL",
             Collections.emptyList()
             );
 }

}