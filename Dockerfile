FROM openjdk:13-jdk

WORKDIR /app

COPY build/libs/application.jar .

ARG VERSION
ENV VERSION $VERSION

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseZGC", "-XX:+TieredCompilation", "-XX:TieredStopAtLevel=1"]
CMD ["-jar", "application.jar"]
