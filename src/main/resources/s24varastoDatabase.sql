
/* CREATE TABLE IF NOT EXISTS Tuote (
    id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL,
    tyyppi VARCHAR(50) NOT NULL,
    vari VARCHAR(50),
    hinta DECIMAL(4, 2),
    varastomaara INT,
    valmistaja VARCHAR(50) NOT NULL,
    koko CHAR(1)
);

CREATE TABLE IF NOT EXISTS TuoteTyyppi (
    id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Valmistaja (
    id BIGSERIAL PRIMARY KEY,
    nimi VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS User (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    passwordh VARCHAR(50) NOT NULL,
    role VARCHAR(10) NOT NULL
); */