package s24.varasto.domain;

import jakarta.persistence.*;

@Entity
public class Tuote {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long tuoteId;

private String tyyppi;
private String vari;
private String koko;
private Double hinta;


@ManyToOne
@JoinColumn(name = "valmistajaId")
private Valmistaja valmistaja;

@Column(name = "valmistaja_nimi") 
private String valmistajaNimi;

public Tuote () {}

public Tuote (String tyyppi,String vari,String koko,Double hinta,Valmistaja valmistaja ){
super();
this.tyyppi=tyyppi;
this.vari=vari;
this.koko=koko;
this.hinta=hinta;
this.valmistaja=valmistaja;
this.valmistajaNimi = valmistaja.getValmistajaNimi();

}

public Long getTuoteId() {
    return tuoteId;
}

public void setTuoteId(Long tuoteId) {
    this.tuoteId = tuoteId;
}

public String getTyyppi() {
    return tyyppi;
}

public void setTyyppi(String tyyppi) {
    this.tyyppi = tyyppi;
}

public String getVari() {
    return vari;
}

public void setVari(String vari) {
    this.vari = vari;
}

public String getKoko() {
    return koko;
}

public void setKoko(String koko) {
    this.koko = koko;
}

public Double getHinta() {
    return hinta;
}

public void setHinta(Double hinta) {
    this.hinta = hinta;
}

public Valmistaja getValmistaja() {
    return valmistaja;
}

public void setValmistaja(Valmistaja valmistaja) {
    this.valmistaja = valmistaja;
    this.valmistajaNimi = valmistaja.getValmistajaNimi(); 
}



@Override
public String toString() {
    return "Tuote [TuoteId=" + tuoteId +
           ", Tyyppi=" + tyyppi +
           ", Väri=" + vari +
           ", Koko=" + koko +
           ", Hinta=" + hinta +
           ", ValmistajaId=" + (valmistaja != null ? valmistaja.getValmistajaId() : "Ei saatavilla") +
           ", ValmistajanNimi=" + (valmistajaNimi != null ? valmistajaNimi : "Ei saatavilla") +
           "]";
}



}
