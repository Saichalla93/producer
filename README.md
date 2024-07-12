This is a Kafka producer Spring Boot application. The topic name used is message-topic, but you can specify your own topic name and Kafka broker details in the properties file located at src/main/resources/application.properties.

You can run this as a Spring Boot application in Eclipse, and you can make the producer publish a message through a browser or Postman using the URI: http://localhost:8080/kafka/publish?message=1.
