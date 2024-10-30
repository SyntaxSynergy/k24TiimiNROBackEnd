package s24.varasto.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ValmistajaRepository extends CrudRepository<Valmistaja, Long> {

    List<Valmistaja> findByValmistajaNimi(String valmistajaNimi);
    
}
