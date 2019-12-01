# Geolocation service

Geolokacijska storitev omogoča deljenje geolokacije ter hranjenje in iskanje geolokacijskih podatkov (to je npr. načrt poti, sled prevoznika, sled potnika, pomembna (iskana) območja, ipd.).

## Pred zahteve 

Za shranjevanje podatkov se uporablja podatkovna baza MongoDB, ki podpira [geoprostorne poizvedbe](https://docs.mongodb.com/manual/geospatial-queries).

```bash
docker-compose -f stack.yml up
```
