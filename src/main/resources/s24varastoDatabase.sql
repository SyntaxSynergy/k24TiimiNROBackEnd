CREATE TABLE IF NOT EXISTS Valmistaja (
    valmistajaId BIGSERIAL PRIMARY KEY,
    valmistajaNimi VARCHAR(50) NOT NULL
);

INSERT INTO Valmistaja (valmistajaNimi) VALUES ('Rukka') , ('Pomppa'), ('Orra'), ('Hurtta');

CREATE TABLE IF NOT EXISTS TuoteTyyppi (
    tyyppiId BIGSERIAL PRIMARY KEY,
    tyyppiNimi VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Tuote (
    tuoteId BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL,
    tyyppiId BIGINT NOT NULL,
    vari VARCHAR(50),
    hinta DECIMAL(4, 2),
    varastomaara INT,
    koko CHAR(1),
    valmistajaId BIGINT NOT NULL,
    FOREIGN KEY (tyyppiId) REFERENCES TuoteTyyppi(tyyppiId),
    FOREIGN KEY (valmistajaId) REFERENCES Valmistaja(valmistajaId)
);
