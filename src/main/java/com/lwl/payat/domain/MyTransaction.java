package com.lwl.payat.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyTransaction {

	
	private int TransactionId;

	private Long mobile;
	private Double amount;

	
	private TransactionStatus status;

}
