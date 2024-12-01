package s24.varasto.domain;
import org.springframework.data.repository.CrudRepository;

public interface TilausRepository extends CrudRepository<Tilaus, Long> {
    Tilaus findByTilausid(Long tilausid);
}
