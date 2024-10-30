package s24.varasto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.Tuote;

@SpringBootApplication
public class VarastoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarastoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (TuoteRepository repository) {
		return (args) -> {
			repository.save(new Tuote("Flexihihna","Musta","M",10.0,"Flexi"));
			repository.save(new Tuote("Flexihihna","Musta","L",12.0,"Flexi"));
			repository.save(new Tuote("Flexihihna","Punainen","M",10.0,"Flexi"));
		};
	}

}
