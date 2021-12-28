package com.Indrajeet.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
			"Product Service",
			"API for fetching Cart",
			"1.0",
			"Free to use",
			new springfox.documentation.service.Contact("Indrajeet rote", "https://github.com/IndrajeetRote/JFSReact_Assignments.com/", "indrajeetrote@gmail.com.com"),
			"API license",
			"https://github.com/IndrajeetRote/JFSReact_Assignments.com/",
			Collections.emptyList());
	}
}
