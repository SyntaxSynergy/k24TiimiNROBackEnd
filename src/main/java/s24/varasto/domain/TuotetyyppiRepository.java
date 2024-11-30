package s24.varasto.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface TuotetyyppiRepository extends CrudRepository<TuoteTyyppi, Long> {
    Optional<TuoteTyyppi> findByTyyppiNimi(String tyyppiNimi);
}
