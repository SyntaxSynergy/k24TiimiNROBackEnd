package s24.varasto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Tuote {
    
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long tuoteId;

private String tyyppi;
private String vari;
private String koko;
private Double hinta;
private String valmistaja;


public Tuote () {}

public Tuote (String tyyppi,String vari,String koko,Double hinta,String valmistaja ){
super();
this.tyyppi=tyyppi;
this.vari=vari;
this.koko=koko;
this.hinta=hinta;
this.valmistaja=valmistaja;
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

public String getValmistaja() {
    return valmistaja;
}

public void setValmistaja(String valmistaja) {
    this.valmistaja = valmistaja;
}

@Override
	public String toString() {
	return "Tuote [TuoteId=" + tuoteId + ", Tyyppi=" + tyyppi + ", Väri= "+vari+
     ", Koko="+ koko+ ", Hinta="+ hinta +", Valmistaja="+valmistaja+"]";
	}

}
