package s24.varasto.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Tuote {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "tuote_id")
private Long tuoteId;

@NotBlank(message = "Nimi tarvitaan.")
@Column(name = "nimi")
private String nimi;

@NotBlank(message = "Väri tarvitaan.")
@Column(name = "vari")
private String vari;

@NotNull(message = "Hinta tarvitaan.")
@DecimalMin(value = "0.0", inclusive = false, message = "hinta ei voi olla negatiivinen.")
@Column(name = "hinta")
private Double hinta;

@NotNull(message = "ei voi olla tyhjä")
@Min(value = 0)
@Column(name = "varastomaara")
private int varastomaara;

@ManyToOne
@JoinColumn(name = "tyyppi_id", nullable = false)
private TuoteTyyppi tyyppi;

@ManyToOne
@JoinColumn(name = "valmistaja_id")
private Valmistaja valmistaja;

@Enumerated(EnumType.STRING)
private Koko koko;

public Tuote () {}

public Tuote (String nimi,TuoteTyyppi tyyppi,String vari,Double hinta,int varastomaara, Valmistaja valmistaja,Koko koko ){
super();
this.nimi=nimi;
this.tyyppi=tyyppi;
this.vari=vari;
this.hinta=hinta;
this.varastomaara=varastomaara;
this.valmistaja=valmistaja;
this.koko=koko;

}

public Long getTuoteId() {
    return tuoteId;
}

public void setTuoteId(Long tuoteId) {
    this.tuoteId = tuoteId;
}

public String getNimi() {
    return nimi;
}

public void setNimi(String nimi) {
    this.nimi = nimi;
}

public TuoteTyyppi  getTyyppi() {
    return tyyppi;
}

public void setTyyppi(TuoteTyyppi  tyyppi) {
    this.tyyppi = tyyppi;
}

public String getVari() {
    return vari;
}

public void setVari(String vari) {
    this.vari = vari;
}

public Koko getKoko() {
    return koko;
}

public void setKoko(Koko koko) {
    this.koko = koko;
}

public Double getHinta() {
    return hinta;
}

public void setHinta(Double hinta) {
    this.hinta = hinta;
}

public int getVarastomaara() {
    return varastomaara;
}

public void setVarastomaara(int varastomaara) {
    this.varastomaara = varastomaara;
}

public Valmistaja getValmistaja() {
    return valmistaja;
}

public void setValmistaja(Valmistaja valmistaja) {
    this.valmistaja = valmistaja;
}



@Override
public String toString() {
    return "Tuote [tuoteId=" + tuoteId +
    ", nimi=" + nimi +
    ", tyyppi=" + tyyppi +
    ", vari=" + vari +
    ", hinta=" + hinta +
    ", varastomaara=" + varastomaara +
    ", valmistaja=" + valmistaja +
    ", koko=" + koko + "]";
}



}
