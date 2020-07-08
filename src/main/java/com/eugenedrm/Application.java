package com.eugenedrm;

import com.eugenedrm.model.ConcreteObjectA;
import com.eugenedrm.model.Umbrella;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .components(new Components()
            .addExamples("umbrellaExample", new Example().value(new Umbrella(new ConcreteObjectA("x", "y"))))
        );
  }
}
