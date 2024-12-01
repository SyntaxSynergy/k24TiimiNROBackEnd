package s24.varasto.domain;
import org.springframework.data.repository.CrudRepository;

public interface AsiakasRepository extends CrudRepository<Asiakas, Long> {
    Asiakas findBySukunimi(String sukunimi);
}
