package s24.varasto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import s24.varasto.domain.*;

@SpringBootApplication

public class VarastoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VarastoApplication.class, args);
	}
/* 
	@Bean
	public CommandLineRunner demo(
		TuoteRepository tuoteRepository, 
		ValmistajaRepository valmistajaRepository, 
		UserRepository userRepository,
		TuotetyyppiRepository tuotetyyppiRepository) {

		return (args) -> {
			
			TuoteTyyppi vaate = new TuoteTyyppi("VAATE");
			TuoteTyyppi lelu = new TuoteTyyppi("LELU");
			TuoteTyyppi ruoka = new TuoteTyyppi("RUOKA");

			tuotetyyppiRepository.save(vaate);
			tuotetyyppiRepository.save(lelu);
			tuotetyyppiRepository.save(ruoka);

			
			Valmistaja valmistaja1 = new Valmistaja("Rukka");
			Valmistaja valmistaja2 = new Valmistaja("Flexi");
			Valmistaja valmistaja3 = new Valmistaja("Pro Active");
			Valmistaja valmistaja4 = new Valmistaja("TIAKI");

			valmistajaRepository.save(valmistaja1);
			valmistajaRepository.save(valmistaja2);
			valmistajaRepository.save(valmistaja3);
			valmistajaRepository.save(valmistaja4);

		
			tuoteRepository.save(new Tuote("KoiranTakki",vaate,"pinkki",10.0, 5, valmistaja3,Koko.M));
			tuoteRepository.save(new Tuote("Flexihihna",vaate, "Musta", 10.0, 10, valmistaja2,Koko.L));
			tuoteRepository.save(new Tuote("Flexihihna",vaate, "Punainen", 12.0, 2, valmistaja2, Koko.S));
			tuoteRepository.save(new Tuote("Flexihihna",vaate, "Punainen", 12.0, 9, valmistaja2, Koko.S));
			tuoteRepository.save(new Tuote("Koiranlelu Rudolph",lelu, "beige", 5.69, 200, valmistaja4, null));
			User user1 = new User("admin", "$2a$10$UuWOsTUpmZ9ElutsSPn0WuLO3yrrWyjltY3YhHz9LNDSTZi7ucaOC", "ADMIN");
			userRepository.save(user1);
		
			tuoteRepository.findAll().forEach(System.out::println);
		};
	}
*/
}
