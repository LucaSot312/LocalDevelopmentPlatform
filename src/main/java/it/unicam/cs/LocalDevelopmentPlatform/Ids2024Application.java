package it.unicam.cs.LocalDevelopmentPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Ids2024Application {

	public static void main(String[] args) {
		SpringApplication.run(Ids2024Application.class, args);
	}

}
