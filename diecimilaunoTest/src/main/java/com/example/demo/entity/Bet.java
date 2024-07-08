package com.example.demo.entity;

import java.time.Instant;

import com.example.demo.enums.ETypeOfBet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double amount;
	private ETypeOfBet type;
	private Instant timestamp;

	public Long getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ETypeOfBet getType() {
		return type;
	}

	public void setType(ETypeOfBet type) {
		this.type = type;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

}
