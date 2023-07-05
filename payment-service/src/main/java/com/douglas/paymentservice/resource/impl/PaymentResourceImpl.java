package com.douglas.paymentservice.resource.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.paymentservice.model.Payment;
import com.douglas.paymentservice.resource.PaymentResource;
import com.douglas.paymentservice.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource {

	private final PaymentService service;

	@Override
	public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
		service.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
