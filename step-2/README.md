# Desarrollando mi primer contenedor

Ahora vamos a construir nuestro primer contenedor, para ello creamos un fichero * Dockerfile * (aunque en realidad podemos llamarlo con cualquier otro nombre).
Este fichero lo que contiene será una serie de directrices/configuración para crear una imagen, que luego podamos lanzar como contenedor.

Vamos a hacer nuestro propio contenedor de hola mundo, pongamos el siguiente contenido en ese fichero Dockerfile

(exercise-1)
```
FROM alpine:3.6

CMD [ "echo", "Hello World" ]
```

Ahora lo que tenemos que hacer es construir la imagen para poder ejecutarlo:

```
docker build -t my-first-container:1.0.0 .
```

Si en lugar de crear un fichero Dockerfile hemos creado nuestro propio fichero, por ejemplo MyDockerfile, entonces ejecutaríamos

```
docker build -f MyDockerfile -t my-first-container:1.0.0 .
```

Ahora solo tendríamos que lanzar nuestro contenedor:

```
docker run my-first-container:1.0.0
```

## Construyendo un ejemplo más complejo

Ahora vamos a crear un contenedor que nos permita crear un entorno de trabajo previo con diferentes comandos útiles.

Veamos el siguiente ejemplo:

(exercise-2)
```
FROM alpine:3.6

RUN  mkdir /app

RUN touch fichero_creado_durante_la_construcción_de_la_imagen.txt

COPY fichero_copiado /app

ADD my-folder /app2

CMD [ "curl", "www.google.es" ]
```

Ups! Petardazo al canto, analicemos por qué ha pasado esto y veamos la solución y algunos tips interesantes.

## Y si usamos un Entrypoint ... y variables de entorno

Siempre hemos estado usando un CMD para lanzar nuestro contenedor pero ¿por qué no usar un entrypoint? y ¿qué es?

Construir una imagen 100% estática puede no ser la mejor de las soluciones en todos los casos, si no que queremos que cada contenedor instanciado de una imagen puedan tener diferentes comportamiento, por ejemplo apuntando a diferentes bases de datos en función del entorno. Aquí entran en juego las variables de entorno.

Veamos el siguiente Dockerfile

(exercise-3)
```
FROM alpine:3.6

RUN apk add --update \
    curl

COPY my-entrypoint.sh /

RUN chmod +x /my-entrypoint.sh

RUN cat /my-entrypoint.sh

ENTRYPOINT [ "sh", "/my-entrypoint.sh" ]
```

Y el contenido de nuestro entrypoint precisamente es:

```
#/bin/bash

curl $SOME_URL
```


## Lets Practice!

Ejecutar un contenedor que esté basado en Ubuntu, que instale python y que cuando se ejecute lo que devuelva sea la versión de python que habéis instalado.