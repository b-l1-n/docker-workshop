FROM jamesdbloom/docker-java8-maven

EXPOSE 8080

ADD ./source /source

RUN mkdir /app

RUN mvn -f /source/pom.xml clean package -Dmaven.test.skip

RUN cp /source/target/*.jar /app/app.jar

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "/app/app.jar"]