package fm.wrapped.musicgator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fm.wrapped.musicgator")
public class MusicGatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicGatorApplication.class, args);
	}

}
