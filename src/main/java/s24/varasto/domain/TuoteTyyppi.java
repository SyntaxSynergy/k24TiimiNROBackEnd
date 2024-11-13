package s24.varasto.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tuotetyypit")
public class TuoteTyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tyyppiId;

    @Column(nullable = false, unique = true)
    private String tyyppiNimi;

  
    public TuoteTyyppi() {}

    public TuoteTyyppi(String tyyppiNimi) {
        this.tyyppiNimi = tyyppiNimi;
    }


    public Long getTyyppiId() {
        return tyyppiId;
    }

    public void setTyyppiId(Long tyyppiId) {
        this.tyyppiId = tyyppiId;
    }

    public String getTyyppiNimi() {
        return tyyppiNimi;
    }

    public void setTyyppiNimi(String tyyppiNimi) {
        this.tyyppiNimi = tyyppiNimi;
    }
}
