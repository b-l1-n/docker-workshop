# Conceptos y comandos básicos de Docker

Vamos a entrar directamente en materia y si tenemos instalado Docker en nuestra máquina lo primero que vamos a hacer es ejecutar el siguiente comando:

```
docker run hello-world
```

## ¿Qué es lo que ha pasado?

Hemos descargado a nuestro registry local la imagen que se llamada hello-world (su último tag) y hemos ejecutado el contenedor con el comando que se le ha especificado (lo veremos más adelante)

Para comprobar que imágenes tenemos descargadas en nuestro registry local podemos ejecutar el siguiente comando:

```
docker images
```

Si queremos ver que contenedores tenemos en ejecución ejecutamos:

```
docker ps
```

oh! ¿Dónde está el contenedor que acabo de ejecutar?

```
docker ps -a
```

¿Que diferencia hay entre una imagen y un contenedor?
