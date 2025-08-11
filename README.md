# Electric-fraud
## Instrucciones de uso
Para poder probar la aplicación podeis hacer uso de cualquier fichero csv o xml con la misma estructura que el que me facilitasteis. 
Os dejo los ficheros antiguos por si ya os sirven. 
### Directamente en java
- Para probarlo en java hace falta tener la version 21 de java y compilar con maven a partir del pom que he definido. Una vez se genere el jar ejecutais:
    
    `java -jar electric-fraud.jar (ruta del fichero)`

- El resultado se mostrara en el propio terminal. 

### A traves de docker
- Como alternativa, se puede ejucatar la aplicacion a traves de la imagen docker definida en el repositorio. 
Basta con ejecutar esto en la raiz del proyecto (*Donde tenemos el Dockerfile*):

    `docker build -t "electric-fraud" .`

- Una vez construido podemos ejecutar el siguiente comando:

  `docker run --rm -it -v $(pwd)/readings.xml:/app/readings.xml electric-fraud readings.xml` 

- *readings.xml* puede ser cualquier archivo (xml o csv) que tengamos en el directorio que se ejecuta la instrucción y sera el que procese nuestra aplicación.
