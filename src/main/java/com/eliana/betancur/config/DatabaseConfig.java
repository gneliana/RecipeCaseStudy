package com.eliana.betancur.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.eliana.betancur")
public class DatabaseConfig {

}
