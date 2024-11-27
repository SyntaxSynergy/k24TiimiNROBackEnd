package s24.varasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

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
    private TuotetyyppiRepository tuoteTyyppiRepository;

    @Test
    public void addTuoteToDatabase(){
        Valmistaja valmistaja = new Valmistaja("valmistajax");
        valmistaja = valmistajaRepository.save(valmistaja);
        String tyyppiNimi = "Lelu";
        TuoteTyyppi tyyppi = tuoteTyyppiRepository.findByTyyppiNimi(tyyppiNimi)
        .orElseThrow(() -> new IllegalArgumentException("Tyyppiä ei löydy: " + tyyppiNimi));
        Tuote tuote = new Tuote("Pallo", tyyppi, "pinkki", 5.00, 10, valmistaja, null);
        tuote = tuoteRepository.save(tuote);
        assertThat(tuote.getTuoteId()).isNotNull();
    }

    @Test
    public void deleteTuoteFromDatabase() {
        Valmistaja valmistaja = new Valmistaja("valmistajax");
        valmistaja = valmistajaRepository.save(valmistaja);
        String tyyppiNimi = "Lelu";
        TuoteTyyppi tyyppi = tuoteTyyppiRepository.findByTyyppiNimi(tyyppiNimi)
        .orElseThrow(() -> new IllegalArgumentException("Tyyppiä ei löydy: " + tyyppiNimi));
        Tuote tuote = new Tuote("Töpön höpö", tyyppi, "pinkki", 10.00, 5, valmistaja, null );
        tuote = tuoteRepository.save(tuote);
        Long tuote_id = tuote.getTuoteId();
        tuoteRepository.deleteById(tuote_id);
        assertThat(tuoteRepository.findById(tuote_id)).isEmpty();
    }

    @Test
    public void deleteValmistajaFromDatabase() {
        Valmistaja valmistaja = new Valmistaja("Kissanpaivat");
        valmistaja = valmistajaRepository.save(valmistaja);
        Long valmistaja_id = valmistaja.getValmistajaId();
        valmistajaRepository.deleteById(valmistaja_id);
    }
}