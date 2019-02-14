FROM alpine:3.6

RUN apk add --update \
    curl

COPY my-entrypoint.sh /

RUN chmod +x /my-entrypoint.sh

RUN cat /my-entrypoint.sh

ENTRYPOINT [ "sh", "/my-entrypoint.sh" ]