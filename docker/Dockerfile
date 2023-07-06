FROM amazoncorretto:17-alpine-jdk AS build

WORKDIR /build

COPY . .

RUN ./gradlew build -x test --no-daemon

FROM amazoncorretto:17.0.7-alpine3.16

ENV SPRING_PROFILES_ACTIVE=prod

COPY --from=build /build/build/libs/application.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar", "-Xms128m", "-Xmx600m"]