package s24.varasto.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tuotetyypit")
public class TuoteTyyppi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tyyppi_id")
    private Long tyyppiId;

    @Column(name = "tyyppi_nimi", nullable = false, unique = true)
    private String tyyppiNimi;

  
    public TuoteTyyppi() {}

    public TuoteTyyppi(String tyyppiNimi) {
        super();
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
    @Override
	public String toString() {
		return tyyppiNimi;
	}
}
