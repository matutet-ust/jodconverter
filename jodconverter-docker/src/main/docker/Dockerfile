FROM adoptopenjdk/openjdk8

VOLUME /tmp
VOLUME /libs

ARG JODCONVERTER_WAR_NAME
ADD ${JODCONVERTER_WAR_NAME} app.war

ENV JAVA_OPTS=""

RUN apt-get update && apt-get -y install vim wget curl unzip libice6 libsm-dev fontconfig libxt6 libxfont2 libcups2 libxrender1 gsfonts libreoffice \
    && wget -O /tmp/open-sans.zip https://www.fontsquirrel.com/fonts/download/open-sansopen-sans.zip \
    && mkdir /root/.fonts \
    && unzip /tmp/open-sans.zip -d /root/.fonts \
    && rm -fr open-sans.zip \
    && fc-cache -fv

EXPOSE 8080
HEALTHCHECK CMD curl -L --fail http://localhost:8080/ || exit 1

CMD ["java", "-jar", "/app.war", "org.springframework.boot.loader.PropertiesLauncher"]
