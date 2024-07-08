package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Questa entità corrisponde alla nostra tabella buste_paga, che conterrà i dati
 * di una persona fittizia, contenente: id per la nostra chiave primaria name
 * che rappresenta il nome lastname che rappresenta il cognome job che
 * rappresenta la mansione che svolge salary, il suo salario menisle
 * 
 * @version 1.0
 * @author Daniele Pasqualetti, Lorenzo Vaccaro
 */
@Entity
public class BustaPaga {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastname;
	private String job;
	private double salary;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
