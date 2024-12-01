package s24.varasto.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tilaus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tilausid;

    @ManyToOne
    @JoinColumn(name = "asiakasid")
    @NotNull
    private Asiakas asiakas;

    @ManyToOne
    @JoinColumn(name = "tuoteid")
    @NotNull
    private Tuote tuote;


    public Tilaus() {
    }

    public Tilaus(Asiakas asiakas, Tuote tuote) {
        this.asiakas = asiakas;
        this.tuote = tuote;
    }

    @PrePersist
    private void reduceQuantity() {
        if (tuote != null) {
            tuote.setVarastomaara(tuote.getVarastomaara() - 1);
        }
    }

    public Long getTilausid() {
        return tilausid;
    }

    public void setTilausid(Long tilausid) {
        this.tilausid = tilausid;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public Tuote getTuote() {
        return tuote;
    }

    public void setTuote(Tuote tuote) {
        this.tuote = tuote;
    }

    @Override
    public String toString() {
        return "Tilaus [asiakas=" + asiakas + ", tilausid=" + tilausid + ", tuote=" + tuote + "]";
    }
}
    