package com.example.introTddParte2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

/**
 * Questa applicazione deve fare queste cose:
 * Alla ricezione di un numero da 1 a 100, deve stampare tante righe quanto è il numero in input
 * Il contenuto delle righe cambia in base alla riga per ogni riga si deve stampare il suo numero
 * regola 1:
 * se la riga è divisibile per 3, io voglio stampare "Kuksa!"
 * se la riga è divisibile per 5, io voglio stampare "Sauna!"
 * se la riga è divisibile sia per 3 che per 5, voglio stampare entrambe le stringhe ("Kuksa!Sauna!")
 */
public class App {

	static Scanner consoleInput = new Scanner(System.in);

	public static void main(String[] args) {
		
		KuksaSauna ks = new KuksaSauna();
		
		System.out.println("Inserisci un valore da 1 a 100 e goditi la sorpresa.");
		
		int input = consoleInput.nextInt();
		
		ArrayList<String> listaDiRighe = ks.generate(input);
		
		for (String string : listaDiRighe) {
			System.out.println(string);
		}
	}
}
