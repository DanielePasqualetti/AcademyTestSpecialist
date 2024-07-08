package giorno7;

import java.util.Scanner;

public class RubricaMain {

	static Scanner consoleInput = new Scanner(System.in);

	public static void main(String[] args) {

		// aggiustare la persona in modo che gli attributi siano validi per una rubrica
		// dobbiamo creare delle funzioni che in base all'azione che dobbiamo fare la
		// eseguono sull'array
		Rubrica rubrica = new Rubrica(10);

		// CREARE UN MENU CON LA POSSIBILITà DI SCELTA DATA ALL'UTENTE RISPETTO
		// ALL'INPUT CHE ANDRA AD INSERIRE
		// CHIAMANDO I VARI METODI IN BASE ALLA SELEZIONE DELL'UTENTE

		System.out.println("Buongiorno Utente, cosa intendi fare?");
		start(rubrica);

//		for(int i = 0; i < rubrica.getPersone().length; i++) {
//			//aggiungo un oggetto di tipo persona vuoto
//			rubrica.getPersone()[i] = new Persona();
//			System.out.println("Prego inserire il nome del contatto " + (i + 1) + ":");
//			rubrica.getPersone()[i].setNome(consoleInput.nextLine());
//			System.out.println("Prego inserire il cognome del contatto " + (i + 1) + ":");
//			rubrica.getPersone()[i].setCognome(consoleInput.nextLine());
//			System.out.println("Prego inserire il numero del contatto " + (i + 1) + ":");
//			rubrica.getPersone()[i].setNumero(consoleInput.nextLine());
//			System.out.println("Prego inserire l'email del contatto "  + (i + 1) + ":");
//			rubrica.getPersone()[i].setEmail(consoleInput.nextLine());
//			System.out.println("Contatto salvato!");
//			System.out.println();
//		}

	}

	private static void start(Rubrica rubrica) {
		// TODO Auto-generated method stub
		System.out.println("Per [V]isualizzare la rubrica premere il tasto [V].");
		System.out.println("Per [G]uardare un singolo contatto nella rubrica premere il tasto [G].");
		System.out.println("Per [A]ggiungere un contatto alla rubrica premere il tasto [A].");
		System.out.println("Per [R]imuovere un contatto alla rubrica premere il tasto [R].");
		System.out.println("Per [C]ercare un contatto nella rubrica premere il tasto [C].");
		System.out.println("Per [U]scire dal programma premere [U]");

		String input = consoleInput.next().toUpperCase();

		if (input.equals("V")) {
			rubrica.getPersone();
			System.out.println();
			start(rubrica);
		} else if (input.equals("G")) {
			System.out.println("Indicare l'indice.");
			if (consoleInput.hasNextInt()) {
				int indice = consoleInput.nextInt();
				rubrica.visualizzaPersona(indice);
				System.out.println();
			} else {
				System.out.println("Valore inserito non valido. Inserire un numero intero.");
				System.out.println();
			}
			start(rubrica);
		} else if (input.equals("A")) {
			System.out.println("Indicare l'indice.");
			if (consoleInput.hasNextInt()) {
				int indice = consoleInput.nextInt();
				rubrica.aggiungiPersona(indice);
				System.out.println();
			} else {
				System.out.println("Valore inserito non valido. Inserire un numero intero.");
				System.out.println();
			}
			start(rubrica);
		} else if (input.equals("R")) {
			System.out.println("Indicare l'indice.");
			if (consoleInput.hasNextInt()) {
				int indice = consoleInput.nextInt();
				rubrica.cancellaPersona(indice);
				System.out.println();
			} else {
				System.out.println("Valore inserito non valido. Inserire un numero intero.");
				System.out.println();
			}
			start(rubrica);
		} else if (input.equals("C")) {
			System.out.println("Indicare il nome.");
			String nomeDaCercare = consoleInput.next();
			rubrica.trovaPersonaPerNome(nomeDaCercare);
			System.out.println();
			start(rubrica);
		} else if (input.equals("U")) {
			System.out.println("Buona giornata Utente.");
		} else {
			System.out.println("Input non valido.");
			System.out.println();
			start(rubrica);
		}
	}
}
