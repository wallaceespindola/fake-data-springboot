package com.example.fakedata.config;

import java.time.Instant;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfig
{
   @Bean
   public HealthIndicator timestampHealthIndicator()
   {
      return () -> Health.up().withDetail("timestamp", Instant.now().toString()).build();
   }
}
