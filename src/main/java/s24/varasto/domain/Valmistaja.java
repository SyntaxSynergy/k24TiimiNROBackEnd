package s24.varasto.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;

@Entity
public class Valmistaja {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long valmistajaId;
private String valmistajaNimi;

  @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Tuote> tuotteet;


public Valmistaja() {}

public Valmistaja(String valmistajaNimi){
    super();
    this.valmistajaNimi=valmistajaNimi;

}
public long getValmistajaId() {
    return valmistajaId;
}

public void setValmistajaId(long valmistajaId) {
    this.valmistajaId = valmistajaId;
}

public String getValmistajaNimi() {
    return valmistajaNimi;
}

public void setValmistajaNimi(String valmistajaNimi) {
    this.valmistajaNimi = valmistajaNimi;
}


@Override
	public String toString() {
		return "Valmistaja [Valmistajaid=" + valmistajaId + ", Valmistaja=" + valmistajaNimi+ "]";
	}
}
