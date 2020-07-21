package com.lwl.payat.web;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.payat.domain.TranactionDto;
import com.lwl.payat.domain.TransactionStatus;

@RestController
@RequestMapping("/api/")
public class PaymentController {

	@GetMapping("{mobile}")
	public int getRandomNumber(@PathVariable Long mobile) {
		Random random = new Random();
		return random.nextInt(2000 - 1000) + 1000;
	}

	@PostMapping("pay")
	public TranactionDto pay(@RequestBody TranactionDto tranactionDto) {
		Random random = new Random();
		tranactionDto.setTransactionId(random.nextInt(5000 - 2000) + 2000);

		if (tranactionDto.getMobile() != null && tranactionDto.getAmount() != null) {
			tranactionDto.setStatus(TransactionStatus.SUCCESS);
		} else {
			tranactionDto.setStatus(TransactionStatus.PENDING);
		}

		return tranactionDto;
	}
}
