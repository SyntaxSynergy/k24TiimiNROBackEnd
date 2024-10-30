package s24.varasto;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.Tuote;
import s24.varasto.domain.ValmistajaRepository;
import s24.varasto.domain.Valmistaja;

@SpringBootApplication
public class VarastoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarastoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (TuoteRepository repository, ValmistajaRepository valmistajaRepository) {
		return (args) -> {
			Valmistaja valmistaja1 = new Valmistaja("Rukka");
			Valmistaja valmistaja2 = new Valmistaja("Flexi");
			Valmistaja valmistaja3 = new Valmistaja("Pro Active");
			
			valmistajaRepository.save(valmistaja1);
			valmistajaRepository.save(valmistaja2);
			valmistajaRepository.save(valmistaja3);


			repository.save(new Tuote("Flexihihna","Musta","M",10.0,valmistaja2));
			repository.save(new Tuote("Flexihihna","Musta","L",12.0,valmistaja2));
			repository.save(new Tuote("Flexihihna","Punainen","M",10.0,valmistaja2));

			repository.findAll().forEach(System.out::println);
		};
	}

}
