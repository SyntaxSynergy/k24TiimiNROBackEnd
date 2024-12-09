# Omppu ja Rane- Lemmikkitarvikekaupan Backend

Lemmikkitarvikekaupan backend-projekti, joka on rakennettu Spring Bootilla. Sovellus hallitsee tuotteiden, asiakkaiden, tilausten ja valmistajien tietoja ja toimii lemmikkitarvikekaupan taustalla.

## Toiminnot

### Etusivu
- `GET /` - Näyttää kaupan etusivun, jonka kautta voi päästä verkkokaupaan tai varasto login sivulle.

### Tuotteet
- `GET /tuotteet` - Näyttää kaikki tuotteet ja tarjoaa mahdollisuuden lisätä uusia tuotteita. Admin voi lisätä, muokata ja poistaa tuotteita.

### Valmistajat
- `GET /valmistajat` - Näyttää kaikki valmistajat ja tarjoaa mahdollisuuden lisätä, muokata ja poistaa valmistajia.

### Asiakkaat
- `GET /asiakkaat` - Näyttää kaikki asiakkaat ja tarjoaa mahdollisuuden lisätä, muokata ja poistaa asiakkaita.

### Tilaukset
- `GET /tilaukset` - Näyttää kaikki tilaukset ja mahdollistaa uusien tilausten luomisen. Admin voi lisätä, muokata ja poistaa tilauksia.

### Kirjautuminen
- `GET /login` - Näyttää kirjautumissivun.

## Vaatimukset

- Java 17
- Spring Boot 3.3.5
- PostgreSQL-tietokanta

## Asennusohjeet

### 1. Kloonaa repository

Kloonaa repository omalle koneellesi komennolla:

```bash
git clone https://github.com/omppu-ja-rane/varasto.git
cd varasto
```

### 2. Määritä tietokanta
- Kirjaudu Heroku-tilillesi ja luo uusi sovellus.
- Lisää PostgreSQL-tietokanta Herokuun.
- Muokkaa application.properties -tiedostoa ja aseta Heroku-tietokannan URL:
```
spring.datasource.url=jdbc:postgresql://<heroku_host>:<port>/<dbname>
spring.datasource.username=<heroku_user>
spring.datasource.password=<heroku_password>
```
## 3. Käynnistä sovellus paikallisesti
- Voit käynnistää sovelluksen komennolla:
```bash
mvn spring-boot:run
  ```

## Admin-toiminnot

- **Tuotteiden hallinta**: Admin voi lisätä, muokata ja poistaa tuotteita.
- **Asiakkaiden hallinta**: Admin voi lisätä, muokata ja poistaa asiakkaita.
- **Tilausten hallinta**: Admin voi luoda, muokata ja poistaa tilauksia.
- **Valmistajien hallinta**: Admin voi lisätä, muokata ja poistaa valmistajia.

## Teknologiat

- **Spring Boot**: Sovelluksen ydinkehys, joka tarjoaa kaikkia tarvittavia ominaisuuksia, kuten REST API:n, tietokannan hallinnan ja käyttäjien autentikoinnin.
- **Spring Security**: Käytetään käyttäjien tunnistamiseen ja roolien hallintaan.
- **Spring Data JPA**: Käytetään tietokannan yhteyksien ja CRUD-toimintojen hallintaan.
- **Thymeleaf**: Käytetään HTML-sivujen renderöintiin.
- **PostgreSQL**: Tietokanta sovelluksen tietojen tallentamiseen.

