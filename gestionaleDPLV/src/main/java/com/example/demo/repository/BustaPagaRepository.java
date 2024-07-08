package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.BustaPaga;

/**
 * Interfaccia che definisce le operazioni di accesso ai dati per l'entità BustaPaga.
 * Estende CrudRepository per fornire operazioni CRUD (Create, Read, Update, Delete).
 * 
 * @version 1.0
 * @author Daniele Pasqualetti, Lorenzo Vaccaro
 */
public interface BustaPagaRepository extends CrudRepository<BustaPaga, Integer> {

	/**
     * Trova tutte le buste paga corrispondenti al nome specificato.
     *
     * @param name Il nome da cercare.
     * @return Un'iterabile di buste paga con il nome corrispondente.
     */
	Iterable<BustaPaga> findByName(String name);

	/**
     * Trova tutte le buste paga corrispondenti al cognome specificato.
     *
     * @param lastname Il cognome da cercare.
     * @return Un'iterabile di buste paga con il cognome corrispondente.
     */
	Iterable<BustaPaga> findByLastname(String lastname);

	/**
     * Trova tutte le buste paga corrispondenti al lavoro specificato.
     *
     * @param job Il lavoro da cercare.
     * @return Un'iterabile di buste paga con il lavoro corrispondente.
     */
	Iterable<BustaPaga> findByJob(String job);

	
}
