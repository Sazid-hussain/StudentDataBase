package in.strike.crude;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CrudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudeApplication.class, args);
	}

}
