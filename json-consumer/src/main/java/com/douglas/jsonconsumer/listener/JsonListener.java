package com.douglas.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.douglas.jsonconsumer.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) {
		log.info("Recebi Pagamento: {}", payment.toString());
		Thread.sleep(3000);
		log.info("Validando Fraude ... ");
		Thread.sleep(3000);
		log.info("Compra aprovada ... ");
		Thread.sleep(3000);
	}

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Payment p) {
		log.info("Gerando PDF do produto de id {}", p.getIdProduct());
		Thread.sleep(3000);
	}

	@SneakyThrows
	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		Thread.sleep(3000);
		log.info("Enviando Email de Confirmação ... ");
	}

}
