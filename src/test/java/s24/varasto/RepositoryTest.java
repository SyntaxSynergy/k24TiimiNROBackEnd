package s24.varasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.TuoteTyyppi;
import s24.varasto.domain.TuotetyyppiRepository;
import s24.varasto.domain.Valmistaja;
import s24.varasto.domain.ValmistajaRepository;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private TuoteRepository tuoteRepository;

    @Autowired
    private ValmistajaRepository valmistajaRepository;

    @Autowired
    private TuotetyyppiRepository tuoteTyyppiRepository;

    @Test
    public void addTuoteToDatabase(){
        Valmistaja valmistaja = new Valmistaja("valmistajax");
        valmistaja = valmistajaRepository.save(valmistaja);
        TuoteTyyppi tyyppi = new TuoteTyyppi("Lelu");
        tyyppi = tuoteTyyppiRepository.save(tyyppi);
        Tuote tuote = new Tuote("Pallo", tyyppi, "pinkki", 5.00, 10, valmistaja, null);
        tuote = tuoteRepository.save(tuote);
        assertThat(tuote.getTuoteId()).isNotNull();
    }

    @Test
    public void deleteTuoteFromDatabase() {
        Valmistaja valmistaja = new Valmistaja("valmistajax");
        valmistaja = valmistajaRepository.save(valmistaja);
        TuoteTyyppi tyyppi = new TuoteTyyppi("Lelu");
        tyyppi = tuoteTyyppiRepository.save(tyyppi);
        Tuote tuote = new Tuote("Pallo", tyyppi, "pinkki", 5.00, 10, valmistaja, null);
        tuote = tuoteRepository.save(tuote);
        Long tuoteId = tuote.getTuoteId();
        tuoteRepository.deleteById(tuoteId);
        assertThat(tuoteRepository.findById(tuoteId)).isEmpty();
    }

    @Test
    public void deleteValmistajaFromDatabase() {
        Valmistaja valmistaja = new Valmistaja("Kissanpaivat");
        valmistaja = valmistajaRepository.save(valmistaja);
        Long valmistajaId = valmistaja.getValmistajaId();
        valmistajaRepository.deleteById(valmistajaId);
    }
}