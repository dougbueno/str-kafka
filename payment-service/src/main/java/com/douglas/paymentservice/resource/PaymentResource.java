package com.douglas.paymentservice.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.douglas.paymentservice.model.Payment;

public interface PaymentResource {

	@PostMapping
	ResponseEntity<Payment> payment(Payment payment);
}
