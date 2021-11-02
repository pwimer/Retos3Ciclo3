package co.usa.retosciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = { "co.usa.retosciclo3" })
@SpringBootApplication
public class Retosciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Retosciclo3Application.class, args);
	}

}
