package com.calculator.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI calculatorOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Multi-Utility Calculator API")
                        .description("REST API for Basic, BMI, Age, EMI, GST, Percentage, and Discount calculators")
                        .version("1.0.0")
                        .contact(new Contact().name("Multi-Utility Calculator Team")));
    }
}
