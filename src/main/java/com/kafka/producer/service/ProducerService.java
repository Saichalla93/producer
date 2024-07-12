package com.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
   private final Logger logger = LoggerFactory.getLogger(ProducerService.class);
   
   @Value("${kafka.topic}")
   private String topic;
   
   @Value("${kafka.message.key}")
   private String key;
   
   @Autowired
   private KafkaTemplate<String, String> kafkaTemplate;

   public void sendMessage(String message) {
      logger.info("Publishing the message with key '{}' : {}", key, message);
      kafkaTemplate.send(topic, key, message);
   }
}
 