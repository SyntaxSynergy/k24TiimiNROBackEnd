package s24.varasto.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "asiakas")
public class Asiakas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long asiakasid;

    @Column(name = "sukunimi")
    @NotBlank(message = "Sukunimi tarvitaan.")
    private String sukunimi;

    @Column(name = "etunimi")
    @NotBlank(message = "Etunimi tarvitaan.")
    private String etunimi;

    @Column(name = "puhelinnumero")
    @NotBlank(message = "Puhelinnumero tarvitaan.")
    private String puhelinnumero;

    @Column(name = "sahkoposti")
    @NotBlank(message = "Sähköposti tarvitaan.")
    private String sahkoposti;

    @Column(name = "katuosoite")
    @NotBlank(message = "Katuosoite tarvitaan.")
    private String katuosoite;

    @Column(name = "postinumero")
    @NotBlank(message = "Postinumero tarvitaan.")
    private String postinumero;

    @Column(name = "postitoimipaikka")
    @NotBlank(message = "Postitoimipaikka tarvitaan.")
    private String postitoimipaikka;

    public Asiakas() {
    }

    public Asiakas(String sukunimi, String etunimi, String puhelinnumero, String sahkoposti, String katuosoite, String postinumero, String postitoimipaikka) {
        this.sukunimi = sukunimi;
        this.etunimi = etunimi;
        this.puhelinnumero = puhelinnumero;
        this.sahkoposti = sahkoposti;
        this.katuosoite = katuosoite;
        this.postinumero = postinumero;
        this.postitoimipaikka = postitoimipaikka;
    }

    public Long getAsiakasid() {
        return asiakasid;
    }

    public void setAsiakasid(Long asiakasid) {
        this.asiakasid = asiakasid;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getPuhelinnumero() {
        return puhelinnumero;
    }

    public void setPuhelinnumero(String puhelinnumero) {
        this.puhelinnumero = puhelinnumero;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public String getKatuosoite() {
        return katuosoite;
    }

    public void setKatuosoite(String katuosoite) {
        this.katuosoite = katuosoite;
    }

    public String getPostinumero() {
        return postinumero;
    }

    public void setPostinumero(String postinumero) {
        this.postinumero = postinumero;
    }

    public String getPostitoimipaikka() {
        return postitoimipaikka;
    }

    public void setPostitoimipaikka(String postitoimipaikka) {
        this.postitoimipaikka = postitoimipaikka;
    }

    @Override
    public String toString() {
        return "Asiakas [asiakasid=" + asiakasid + ", sukunimi=" + sukunimi + ", etunimi=" + etunimi
                + ", puhelinnumero=" + puhelinnumero + ", sahkoposti=" + sahkoposti + ", katuosoite=" + katuosoite
                + ", postinumero=" + postinumero + ", postitoimipaikka=" + postitoimipaikka + "]";
    }

}