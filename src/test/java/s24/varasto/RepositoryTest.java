package s24.varasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s24.varasto.domain.Tuote;
import s24.varasto.domain.TuoteRepository;
import s24.varasto.domain.Valmistaja;

@SpringBootTest
public class RepositoryTest {

    @Autowired
    private TuoteRepository tuoteRepository;

    @Test
    public void addTuoteToDatabase(){
    Valmistaja valmistaja = new Valmistaja("valmistajax");
    Tuote tuote = new Tuote("hihna", "pinkki", "m", 25.00, valmistaja);
    tuoteRepository.save(tuote);
    assertThat(tuote.getTuoteId()).isNotNull();
    }

    @Test
    public void deleteTuoteFromDatabase() {
    Valmistaja valmistaja = new Valmistaja("valmistajax");
    Tuote tuote = new Tuote("hihna", "pinkki", "m", 25.00, valmistaja);
    tuoteRepository.save(tuote);
    Long tuoteId = tuote.getTuoteId();
    tuoteRepository.deleteById(tuoteId);
    }
}
