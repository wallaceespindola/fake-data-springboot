package com.example.fakedata.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig
{
   @Bean
   public GroupedOpenApi apiGroup()
   {
      return GroupedOpenApi.builder().group("fakedata").pathsToMatch("/api/**").build();
   }

   @Bean
   public io.swagger.v3.oas.models.OpenAPI appInfo()
   {
      return new io.swagger.v3.oas.models.OpenAPI().info(
            new Info()
                  .title("Fake Data Spring-Boot API")
                  .description("Demo API using Datafaker + Easy Random over Spring-Boot")
                  .version("1.0.0")
                  .license(new License().name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
            .externalDocs(
                  new ExternalDocumentation().description("Project README").url("https://example.com"));
   }
}
