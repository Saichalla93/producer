package com.kafka.producer.controller;

import com.kafka.producer.service.ProducerService;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/kafka"})
public class KafkaController {
	
   private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
   
   @Autowired
   private ProducerService producerService;

   @GetMapping({"/publish"})
   public ResponseEntity<?> sendMessageToKafkaTopic(@RequestParam("message") @NotBlank String message) {
      try {
         this.producerService.sendMessage(message);
         logger.info("Message '{}' successfully published", message);
         return ResponseEntity.ok("Message successfully published");
      } catch (Exception ex) {
         logger.error("Failed to publish message: {}", ex.getMessage());
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to publish message: " + ex.getMessage());
      }
   }
}