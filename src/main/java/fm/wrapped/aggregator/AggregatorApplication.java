package fm.wrapped.aggregator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class AggregatorApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {

	}

}
