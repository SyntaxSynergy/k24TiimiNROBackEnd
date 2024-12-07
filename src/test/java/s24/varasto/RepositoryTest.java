package s24.varasto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import s24.varasto.domain.Asiakas;
import s24.varasto.domain.AsiakasRepository;
import s24.varasto.domain.Tilaus;
import s24.varasto.domain.TilausRepository;
import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.TuoteTyyppi;
import s24.varasto.domain.TuotetyyppiRepository;
import s24.varasto.domain.Valmistaja;
import s24.varasto.domain.ValmistajaRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private AsiakasRepository asiakasRepository;

    @Autowired
    private TilausRepository tilausRepository;

    @Autowired
    private TuotetyyppiRepository tuotetyyppiRepository;

    @Test
    public void deleteValmistajaFromDatabase() {
        Valmistaja valmistaja = new Valmistaja("Kissanpaivat");
        valmistaja = valmistajaRepository.save(valmistaja);
        Long valmistaja_id = valmistaja.getValmistajaId();
        valmistajaRepository.deleteById(valmistaja_id);
    }

    @Test
    public void addAsiakasToDatabase() {
        Asiakas asiakas = new Asiakas("Heikkila", "Heta", "0409602567", "miumau@gmail.com",
        "Kissakatu 7 b", "00320", "Helsinki");
        asiakas = asiakasRepository.save(asiakas);
    }

    @Test
    public void deleteAsiakasFromDatabase() {
        Asiakas asiakas = new Asiakas("Frigren", "Fiiu", "0409602345", "miuuu@gmail.com", "Maukulankatu 1 b",
        "00500", "Helsinki");
        asiakas = asiakasRepository.save(asiakas);
        Long asiakasId = asiakas.getAsiakasid();
        asiakasRepository.deleteById(asiakasId);
    }

    @Test
public void addTilausToDatabase() {

    Asiakas asiakas = new Asiakas("Höpöseli", "Töpseli", "1234567890", 
    "murr@gmail.com", "Kissala 2 c", "00230", "Helsinki");
    asiakas = asiakasRepository.save(asiakas);

    Valmistaja valmistaja = new Valmistaja("Kissanpaivat");
    valmistaja = valmistajaRepository.save(valmistaja);

    TuoteTyyppi tuotetyyppi = tuotetyyppiRepository.findByTyyppiNimi("LELU")
        .orElseThrow(() -> new RuntimeException("TuoteTyyppi 'LELU' not found"));

    Tuote tuote = new Tuote("Hiiri", tuotetyyppi, "pinkki",12.99, 12, valmistaja, null);
    tuote = tuoteRepository.save(tuote);

    Tilaus tilaus = new Tilaus();
    tilaus.setTuote(tuote);
    tilaus.setAsiakas(asiakas);
    tilaus = tilausRepository.save(tilaus);
}

}