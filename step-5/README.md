# Volumenes en un contenedor

Por último hablemos de volúmenes en Docker. Cuando un contenedor se levanta, podemos operar todo lo que queramos pero ¿qué pasa si matamos el contenedor?

Vamos a hacer una prueba levantado el primero de los contenedores que creamos, el del servicio java, y lo vamos a lanzar pero para interactuar con él.

```
docker exec -it id_nombre_container bash
```

Y ahora vamos a hacer lo siguiente:

Nos vamos a la carpeta HOME:

```
cd ~
```

Y creamos un fichero:

```
touch myFile
```

Ahora vayamos a parar el contenedor y arranquemos. 

Sigue ahí!, ¿Cuál es el problema entonces?

Montemos entonces un volumen para compartirlo entre diferentes contenedores y persistirlos:

```
docker run -v $(pwd):/root -d -p 80:8080 test
```

