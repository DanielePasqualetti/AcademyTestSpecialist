package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Questa Application ci permetterà di gestire le buste paga dei vari lavoratori.
 * Possiamo raccogliere dati riguardo tutti i lavoratori e lavoratori signoli, con ricera tramite nome, cognome, e il lavoro
 * Possiamo eliminare le buste paga in base al loro id
 * Possiamo modificare le buse paga in base al loro id
 * Possiamo aggiungere buste paga sia da parametri che da body
 * @version 1.0 
 * @author Daniele Pasqualetti, Lorenzo Vaccaro
 */
@SpringBootApplication
public class GestionaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionaleApplication.class, args);
	}

}
