# Exponiendo puertos de mi contenedor

Teniendo esas nociones básicas de Docker vayamos ahora vamos a crear un primer servicio con java muy sencillo:

(exercise-1)
```
FROM jamesdbloom/docker-java8-maven

EXPOSE 8080

ADD ./source /source

RUN mkdir /app

RUN mvn -f /source/pom.xml clean package -Dmaven.test.skip

RUN cp /source/target/*.jar /app/app.jar

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "/app/app.jar"]
```

Para lanzar el contenedor solo tenemos que hacer:

```
docker run nombre_container_construido
```

Pero esto nos bloquea la consola, si queremos lanzarlo y dejarl en segundo plano, añadimos -d

```
docker run -d nombre_container_construido
```

Para ver los logs de un container a partir de su identificador podemos hacer:

```
 docker logs id_container
 ```

 O si lo queremos ver continuamente:

 ```
docker logs -f id_container
````


Para comprobar que funciona solo tenemos que hacer curl al siguiente end point:

```
curl localhost/bar
```

Ups de nuevo!, nos ha fallado algo. El puerto!!

```
docker run -d -P nombre_container_construido
```

o bien

```
docker run -d -p 80:8080 nombre_container_construido
```

Si nos fijamos bien, al hacer el comando ps tenemos que tener algo similar a esto:

```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                     NAMES
af3fe07f656a        test                "/usr/lib/jvm/java-8…"   11 minutes ago      Up 11 minutes       0.0.0.0:32768->8080/tcp   hardcore_feistel
```

