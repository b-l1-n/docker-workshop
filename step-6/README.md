# Orquestación con Docker Compose

Let's go magic! Como hemos podido ver todos estos comandos son demasiados y muy tediosos de utilizar en caso de que queramos lanzarlos varias veces o queramos probar diferentes configuraciones.

Para ello tenemos Docker Compose que nos permite orquestar todo esto de manera muy sencilla.

Repliquemos el ejemplo del microservicio y el contenedor con curl a través de un fichero docker-compose:

(exercise-1)
```
version: '3'
services:
  microservice-1:
    image: java-service:1.0.0
    hostname: java-service-1
    ports:
      - "80:8080"
    volumes:
      - ./data:/root
  microservice-2:
    build:
      context: ./java_service
    ports:
      - "81:8080"
    volumes:
      - ./data:/root
```

Y lanzamos el fichero con:

```
docker-compose up -d
```

Si queremos utilizar un compose concreto usamos:

```
docker-compose -f nombre_fichero up -d
```


## Lets Practice!

Realizar un fichero Docker compose, que levante 2 microservicios que tenemos en java y que compartan un volumen de uncarpeta data, un microservicio que monte el volumen data2 y otro contenedor con un mongo 3.2 que monte el volument data_backup.