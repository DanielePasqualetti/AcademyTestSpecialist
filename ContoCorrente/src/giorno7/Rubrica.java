package giorno7;

import java.util.Scanner;

public class Rubrica {

	static Scanner consoleInput = new Scanner(System.in);

	private Persona[] persone;

	public Rubrica(int grandezza) {
		this.persone = new Persona[grandezza];
	}

	public void getPersone() {
		for (int i = 0; i < persone.length; i++) {
			if (persone[i] != null) {
				System.out.println(persone[i].toString());
			}
		}
	}

	public void aggiungiPersona(int posizione) {
		if (posizione < 0 || posizione > persone.length) {
			System.out.println("La posizione indicata non è valida.");
		} else {
			if (persone[posizione] == null) {
				persone[posizione] = new Persona();
			}
			System.out.println("Inserire il Nome.");
			persone[posizione].setNome(consoleInput.nextLine());
			System.out.println("Inserire il Cognome.");
			persone[posizione].setCognome(consoleInput.nextLine());
			System.out.println("Inserire il Numero di telefono.");
			persone[posizione].setNumero(consoleInput.nextLine());
			System.out.println("Inserire la Mail.");
			persone[posizione].setEmail(consoleInput.nextLine());
			System.out.println();
			System.out.println("L'utente " + persone[posizione].getNome() + " " + persone[posizione].getCognome()
					+ " è stato registrato.");
		}
	}

	public void cancellaPersona(int posizione) {
		if (posizione < 0 || posizione > persone.length) {
			System.out.println("La posizione indicata non è valida.");
		} else if (persone[posizione] == null) {
			System.out.println("Nessuna persona trovata nella posizione indicata.");
		} else {
			System.out.println("La persona " + persone[posizione].getNome() + " " + persone[posizione].getCognome() + " è stata rimossa dalla rubrica.");
			persone[posizione].setNome("");
			persone[posizione].setCognome("");
			persone[posizione].setNumero("");
			persone[posizione].setEmail("");
		}

	}

	public void visualizzaPersona(int posizione) {
		if (posizione < 0 || posizione > persone.length) {
			System.out.println("La posizione indicata non è valida.");
		} else if (persone[posizione] == null) {
			System.out.println("Nessuna persona trovata nella posizione indicata.");
		} else {
			System.out.println(persone[posizione].toString());
		}
	}

	public void trovaPersonaPerNome(String nome) {
	    for (int i = 0; i < persone.length; i++) {
	        if (persone[i] != null && persone[i].getNome().equalsIgnoreCase(nome)) {
	            System.out.println(persone[i].toString());
	        }
	    }
	}


}
