FROM alpine:3.6

RUN  mkdir /app

RUN touch fichero_creado_durante_la_construcción_de_la_imagen.txt

COPY fichero_copiado /app

ADD my-folder /app2

RUN apk add --update \
    curl

CMD [ "curl", "www.google.es" ]