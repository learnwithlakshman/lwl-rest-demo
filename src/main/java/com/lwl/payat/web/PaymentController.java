package com.lwl.payat.web;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.payat.domain.Payment;

@RestController
@RequestMapping("/api/")
public class PaymentController {

	@GetMapping()
	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(2000 - 1000) + 1000;
	}

	@PostMapping("pay/{mobile}/{amount}")
	public Payment pay(@PathVariable Long mobile, @PathVariable Double amount) {
		String message = "Payment failed";
		if (mobile != null && amount != null) {
			message = "Payment of Rs: " + amount + " successfully payed to : " + mobile+".";
		}
		return new Payment(mobile, amount, message);
	}
}
