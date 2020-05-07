package dev.agboneni.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("dev.agboneni.entities") //enables to find entities 
@ComponentScan("dev.agboneni") //scan all packages and any class with @Component gets built
@EnableJpaRepositories("dev.agboneni.repositories")// tells spring where to find repositories
public class RpasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpasApplication.class, args);
	}

}
