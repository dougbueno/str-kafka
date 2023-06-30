package com.douglas.strproducer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		log.info("Send Message {}", message);
		kafkaTemplate.send("str-topic", message);
//		kafkaTemplate.send("str-topic", message).whenComplete((result, ex) -> {
//			if (ex != null) {
//				log.error("Mensagem enviada com erro");
//			}
//
//			log.info("Message: {}", message.toString());
//			log.info("Topic: {}", result.getRecordMetadata().topic());
//			log.info("Particion: {}", result.getRecordMetadata().partition());
//			log.info("Offset: {}",result.getRecordMetadata().offset());
//			log.info("TimeStamp: {}",result.getRecordMetadata().timestamp());
//
//
//		});
	}
}
