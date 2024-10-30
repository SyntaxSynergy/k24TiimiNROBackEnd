package s24.varasto.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface TuoteRepository extends CrudRepository<Tuote, Long> {
    Tuote findByTyyppi(String tyyppi);
    List<Tuote> findByValmistaja(Valmistaja valmistaja);



}
