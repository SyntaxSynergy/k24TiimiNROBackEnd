package s24.varasto.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Valmistaja {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "valmistaja_id")
private Long valmistajaId;

@NotBlank(message = "Nimi tarvitaan.")
@Column(name = "valmistaja_nimi")
private String valmistajaNimi;

  @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Tuote> tuotteet;


public Valmistaja() {}

public Valmistaja(String valmistajaNimi){
    super();
    this.valmistajaNimi=valmistajaNimi;

}
public Long getValmistajaId() {
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
public List<Tuote> getTuotteet() {
    return tuotteet;
}

public void setTuotteet(List<Tuote> tuotteet) {
    this.tuotteet = tuotteet;
}

@Override
	public String toString() {
		return valmistajaNimi;
	}
}
