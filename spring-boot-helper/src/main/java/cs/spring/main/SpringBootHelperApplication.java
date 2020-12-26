package cs.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("cs.spring")
@EntityScan(basePackages="cs.spring.entity.jpa")
@EnableJpaRepositories(basePackages="cs.spring.entity.repositories")
public class SpringBootHelperApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelperApplication.class, args);
	}

}
