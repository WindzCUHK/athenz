FROM athenz-conf AS athenz-conf

FROM adoptopenjdk/openjdk8:alpine-jre

COPY --from=builder /usr/bin/athenz-conf /usr/bin/athenz-conf

RUN apk update && \
    apk add --no-cache git && \
    apk add --no-cache curl && \
    apk add --no-cache openssl && \
    rm -rf /var/cache/apk/*

# RUN mkdir /athenz
WORKDIR /athenz

ENTRYPOINT [ "echo" ]
CMD [ "docker image for Athenz setup" ]
