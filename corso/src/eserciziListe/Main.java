package eserciziListe;

import java.util.Scanner;

public class Main {

	static Scanner consoleInput = new Scanner(System.in);

	static Catalogo catalogo = new Catalogo();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean uscita = true;

		Libro libro1 = new Libro("Il Signore degli Anelli", "Tolkien", 1954);
		Libro libro2 = new Libro("Harry Potter", "Rowling", 1997);
		Libro libro3 = new Libro("Guida galattica per gli autostoppisti", "Adams", 1979);
		catalogo.aggiungiLibro(libro1);
		catalogo.aggiungiLibro(libro2);
		catalogo.aggiungiLibro(libro3);

		while (uscita) {
			System.out.println("\nMenu:");
			System.out.println("1. Visualizza catalogo");
			System.out.println("2. Cerca libro per titolo");
			System.out.println("3. Aggiungi libro");
			System.out.println("4. Rimuovi libro");
			System.out.println("5. Esci");
			System.out.print("Seleziona un'opzione: ");

			if (consoleInput.hasNextInt()) {
				int scelta = consoleInput.nextInt();
				consoleInput.nextLine();

				switch (scelta) {
				case 1:
					catalogo.visualizzaCatalogo();
					break;
				case 2:
					System.out.println("Inserisci il titolo da cercare: ");
					String titoloCercato = consoleInput.nextLine();
					Libro libroCercato = catalogo.cercaLibroPerTitolo(titoloCercato);
					if (libroCercato != null) {
						System.out.println(libroCercato.toString());
					} else {
						System.out.println("Libro non trovato.");
					}
					break;
				case 3:
					System.out.println("Inserisci il titolo: ");
					String titoloAggiunto = consoleInput.nextLine();
					System.out.println("Inserisci il l'autore: ");
					String autoreAggiunto = consoleInput.nextLine();
					System.out.println("Inserisci l'anno di scrittura: ");
					int annoAggiunto = consoleInput.nextInt();
					catalogo.aggiungiLibro(new Libro(titoloAggiunto, autoreAggiunto, annoAggiunto));
					break;
				case 4:
					consoleInput.nextLine();
					System.out.println("Inserisci il titolo da rimuovere: ");
					String titoloRimosso = consoleInput.nextLine();
					catalogo.rimuoviLibro(titoloRimosso);
					break;
				case 5:
					uscita = false;
					break;
				default:
					System.out.println("Scelta non valida.");
					consoleInput.nextLine();
					break;
				}

			} else {
				System.out.println("Scelta non valida.");
				consoleInput.nextLine();
				continue;
			}
		}
	}

}
