# ELECTRIC-FRAUD
## Como ejecutar

### Directamente en java
### A traves de docker

`docker build -t "electric-fraud" .`

`docker run --rm -it -v $(pwd)/readings.xml:/app/readings.xml electric-fraud sh` 

