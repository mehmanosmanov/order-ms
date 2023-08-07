FROM openjdk
WORKDIR /home
COPY build/libs/order-ms-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/home/order-ms-0.0.1-SNAPSHOT.jar"]