package com.lwl.payat.web;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.payat.domain.MyTransaction;
import com.lwl.payat.domain.MyTransactionDto;
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
	public MyTransaction pay(@RequestBody MyTransactionDto transactionDto) {
		MyTransaction transaction = new MyTransaction();
		Random random = new Random();
		transaction.setTransactionId(random.nextInt(5000 - 2000) + 2000);

		transaction.setAmount(transactionDto.getAmount());
		transaction.setMobile(transactionDto.getMobile());

		if (transactionDto.getMobile() != null && transactionDto.getAmount() != null) {
			transaction.setStatus(TransactionStatus.SUCCESS);
		} else {
			transaction.setStatus(TransactionStatus.PENDING);
		}

		return transaction;
	}
}
