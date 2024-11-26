/*
CREATE TABLE IF NOT EXISTS Valmistaja (
    valmistaja_id BIGSERIAL PRIMARY KEY,
    valmistaja_nimi VARCHAR(50) NOT NULL
);

INSERT INTO Valmistaja (valmistaja_nimi) VALUES ('Rukka') , ('Pomppa'), ('Orra'), ('Hurtta');

CREATE TABLE IF NOT EXISTS Tuotetyypit (
    tyyppi_id BIGSERIAL PRIMARY KEY,
    tyyppi_nimi VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tuote (
    tuote_id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL,
    tyyppi_id BIGINT NOT NULL,
    vari VARCHAR(50),
    hinta DECIMAL(4, 2),
    varastomaara INT,
    koko CHAR(1),
    valmistaja_id BIGINT NOT NULL,
    FOREIGN KEY (tyyppi_id) REFERENCES Tuotetyypit(tyyppi_id),
    FOREIGN KEY (valmistaja_id) REFERENCES Valmistaja(valmistaja_id)
);

spring.jpa.hibernate.ddl-auto=update

CREATE TABLE IF NOT EXISTS varastoUser (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(40),
    password VARCHAR(40),
    role VARCHAR(30)
);

<dependency>
<groupId>org.postgresql</groupId>
<artifactId>postgresql</artifactId>
<scope>runtime</scope>
</dependency>

spring.data.rest.base-path=/api
spring.jpa.show-sql=true
spring.datasource.url=jdbc:postgresql://localhost:5432/s24varasto
spring.datasource.username=postgres
spring.datasource.password=github
spring.jpa.hibernate.ddl-auto=none


spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.application.name=varasto
spring.jpa.show-sql=true

<dependency>
 <groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
</dependency>

*/