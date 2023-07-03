package com.douglas.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION_HANDLER ::: Capturei um erro");
		log.info("PAYLOAD ::: {}", message.getPayload());
		log.info("HEADERS ::: {}", message.getHeaders());
		log.info("OFFSET ::: {}", message.getHeaders().get("kafka_offset"));
		log.info("MESSAGE ::: {}", exception.getMessage());
		return null;
	}

}
