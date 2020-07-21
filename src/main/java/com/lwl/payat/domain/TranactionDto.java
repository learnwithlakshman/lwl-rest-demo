package com.lwl.payat.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranactionDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int TransactionId;

	private Long mobile;
	private Double amount;

	@JsonProperty(access = Access.READ_ONLY)
	private TransactionStatus status;

}
