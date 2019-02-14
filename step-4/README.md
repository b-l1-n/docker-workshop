# Montando mi red de contenedores

Veamos ahora como intercomunicar diferentes contenedores. Para ello vamos a utilizar los contenedores que creamos con el curl con variables de entorno y el contenedor de java con el microservicio.

En primer lugar chequeamos que tenemos el contenedor del servicio Java y que hemos expuesto correctamente su puerto, si no lo lanzamos.

Ahora lanzamos el contenedor del curl así:

```
 docker run -e SOME_URL=localhost/bar curl
```

Vaya!, no nos imaginabamos que iba a petar eh? XD

¿Qué es lo que está pasando?

* Estoy llamando a localhost
* No veo el contenedor del microservicio
* ¿Estoy seguro de qué estoy invocando con el puerto correcto?

Entonces arrancamos el contenedor con la opción --link:

```
docker run --link id_o_nombre_container:java-service  -e SOME_URL=java-service:8080/bar curl_conainer_name
```

Et voilá!, analicemos que hemos hecho y que ha pasado.

