FROM athenz-conf AS athenz-conf

FROM adoptopenjdk/openjdk8:alpine-jre

COPY --from=athenz-conf /usr/bin/athenz-conf /usr/bin/athenz-conf

# coreutils: base64
# ncurses: tput
RUN apk update && \
    apk add --no-cache coreutils && \
    apk add --no-cache ncurses && \
    apk add --no-cache git && \
    apk add --no-cache curl && \
    apk add --no-cache tree && \
    apk add --no-cache openssl && \
    rm -rf /var/cache/apk/*

# RUN mkdir /athenz
WORKDIR /athenz

CMD [ "echo", "This is a docker image for Athenz setup" ]
