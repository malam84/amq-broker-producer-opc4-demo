FROM openjdk:8
EXPOSE 8080
ADD /target/amq-broker-producer-opc4-demo-0.0.1-SNAPSHOT.jar amq-broker-producer-opc4-demo.jar
ENTRYPOINT ["java", "-jar", "amq-broker-producer-opc4-demo.jar"]
