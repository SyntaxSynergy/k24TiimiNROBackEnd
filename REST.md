-Purpose of this document-
Tässä dokumentissa kuvataan, mitä REST-palveluita varasto sovelluksemme tarjoaa. Tätä dokumenttia voi käyttää apuna 

-REST resources (services)-
1.Hae kaikki tuotteet-> http://localhost:8080/tuotteet
2.Lisää uusi tuote-> http://localhost:8080/uusituote
3.Muokkaa tuotetta-> http://localhost:8080/edit/{id}
4.Poista tuote-> http://localhost:8080/tuotteet/{id}
5.Lisää uusi valmistaja-> http://localhost:8080/uusivalmistaja

-REST requests and responses-
1. Hae kaikki tuotteet
HTTP method: GET
API call: http://localhost:8080/tuotteet
Request body: -
Response example below:


[
  {
    "tuoteId": 1,
    "tyyppi": "Flexihihna",
    "vari": "Musta",
    "koko": "M",
    "hinta": 10.0,
    "valmistaja": {
      "valmistajaId": 2,
      "valmistajaNimi": "Flexi"
    }
  },
  {
    "tuoteId": 2,
    "tyyppi": "Flexihihna",
    "vari": "Musta",
    "koko": "L",
    "hinta": 12.0,
    "valmistaja": {
      "valmistajaId": 2,
      "valmistajaNimi": "Flexi"
    }
  },
  {
    "tuoteId": 3,
    "tyyppi": "Flexihihna",
    "vari": "Punainen",
    "koko": "M",
    "hinta": 10.0,
    "valmistaja": {
      "valmistajaId": 2,
      "valmistajaNimi": "Flexi"
    }
  }
]

2. Lisää uusi tuote
HTTP method: GET
API call: http://localhost:8080/uusituote
Request body: -
Response example below:

3. Muokkaa tuotetta
HTTP method: GET
API call: http://localhost:8080/edit/{id}
Request body: -
Response example below:

4. Poista tuote
HTTP method: GET
API call: http://localhost:8080/tuotteet/{id}
Request body: -
Response example below:

5. Lisää uusi valmistaja
HTTP method: GET
API call: http://localhost:8080/uusivalmistaja
Request body: -
Response example below:

[
  {
    "valmistajaId": 1,
    "valmistajaNimi": "Rukka"
  },
  {
    "valmistajaId": 2,
    "valmistajaNimi": "Flexi"
  },
  {
    "valmistajaId": 3,
    "valmistajaNimi": "Pro Active"
  }
]

-HTTP methods-
//lisää table jossa kaikki listattuna