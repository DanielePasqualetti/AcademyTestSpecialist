package giorno6;

import java.util.Random;
import java.util.Scanner;

//"Cosa Succede Se"

public class TombolaGruppo {

	static Scanner consoleInput = new Scanner(System.in);
	static Random rng = new Random();

	/*
	 * Stampa delle cartelle dei giocatori
	 */
	static void stampaCartelle(int[][][] cartellePerGiocatore, int nGiocatori, int nCartelle) {
		// Stampa delle cartelle
		for (int i = 0; i < nGiocatori; i++) {
			System.out.println("\n\n\tGiocatore numero: " + (i + 1));
			for (int j = 0; j < nCartelle; j++) {
				System.out.println("\nCartella numero: " + (j + 1));
				for (int k = 0; k < 15; k++) {
					System.out.print(cartellePerGiocatore[i][j][k] + " | ");
				}
				System.out.println();
			}
		}
	}

	static void generazioneCartelle(int[][][] cartellePerGiocatore, int nGiocatori, int nCartelle) {
		// Generiamo le cartelle, ogni cartella ha 15 numeri diversi
		for (int i = 0; i < cartellePerGiocatore.length; i++) {
			for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
				// per ogni numero della cartella
				// ho aggiunto il - 1 perchè, da ragionamento, le cartelle contengono 16 valori,
				// di cui l'ultimo della colonna, è il numero di numeri estratti in quella
				// cartella.
				for (int k = 0; k < cartellePerGiocatore[i][j].length - 1; k++) {
					// generiamo un numero casuale graze a rng
					// controlliamo che non sia già stato inserito nella cartella, e nel caso
					// inserirlo.
					// per fare questo controllo, ho bisogno di mettere a confronto tutti i numeri
					// della cartella attuale con il numero generato.
					int numeroEstrattoCartella;
					boolean numeroPresente;
					// Verifica se il numero inserito non è presente nella cartella, se è presente
					// ricomincia il ciclo
					do {
						numeroPresente = false;
						numeroEstrattoCartella = rng.nextInt(90) + 1;
						for (int x = k; x >= 0; x--) {
							if (cartellePerGiocatore[i][j][x] == numeroEstrattoCartella)
								numeroPresente = true;
						}
					} while (numeroPresente);

					// inserisco il valore nella cartella
					cartellePerGiocatore[i][j][k] = numeroEstrattoCartella;
				}
			}
		}
	}
	
	static boolean controlloCartelle (int[][][] cartellePerGiocatore, int numeroEstratto) {
		// verifico che il numero estratto sia presente nelle cartelle dei giocatori
			for (int i = 0; i < cartellePerGiocatore.length; i++) {
				for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
					// cartellePerGiocatore[i][j] - 1 perchè il 16esimo elemento corrisponde al
					// nostro caro e amato contatore
					for (int k = 0; k < cartellePerGiocatore[i][j].length - 1; k++) {
						// controllo il numero estratto con i numeri all'interno delle cartelle
						if (numeroEstratto == cartellePerGiocatore[i][j][k]) {
							// incremento il 16esimo elemento
							cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]++;
							// verifico se la tombola è stata fatta.
							if (cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1] == 15) {
								return true;
							}
						}
					}
				}
			}
			return false;
	}
	
	static void stampaTurno (int[][][] cartellePerGiocatore, int numeroEstratto, int contatoreEstrazione) {
		// stampiamo il numero delle estrazioni
					System.out.println("Turno Estrazione: " + contatoreEstrazione);

					// numero estratto attualmente
					System.out.println("Numero Estratto: " + numeroEstratto);

					// numeri mancanti alle altre cartelle per ogni giocatore
					for (int i = 0; i < cartellePerGiocatore.length; i++) {
						System.out.println("Giocatore " + (i + 1) + ":");
						// per ogni cartella
						for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
							System.out.print("Cartella " + (j + 1) + ":");
							System.out.println("Numeri mancanti : "
									+ (15 - cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]));
						}

				}
	}
	
	static void report (int[][][] cartellePerGiocatore) {
		// una volta usciti dal gioco, ovvero almeno una tombola è stata effettuata,
				// verranno stampati i dati finali:
				// ogni giocatore
				for (int i = 0; i < cartellePerGiocatore.length; i++) {
					// ogni cartella
					for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
						if (cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1] == 15) {
							System.out.println("Il Giocatore " + (i + 1) + " ha vinto con la cartella: " + (j + 1));
						} else {
							System.out.println("La cartella del giocatore " + (i + 1) + " non ha vinto. Cartella " + (j + 1)
									+ ": Numeri mancanti : "
									+ (15 - cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]));

						}
					}
				}
	}

	public static void main(String[] args) {
// TODO Auto-generated method stub
// Voglio un app che simuli il gioco della tombola dalla a alla z con alcune
// semplificazioni
// devo avere: un numero di giocatori e un numero di cartelle che ogni giocatore
// puo avere (ogni giocatore ha lo stesso numero di cartelle, ovvero 3)
// si vince solo con la tombola
// voglio generare queste cartelle tramite il Random (generatore pseudo casuale
// 15 numeri da 1 a 90)
// ad ogni estrazione per ogni cartella bisogna sapere quanti numeri mancano, non
// ci devono essere numeri ripetuti nell'estrazione
// bisogna tenere conto del numero delle estrazioni, di chi è la cartella, e
// quanti numeri mancano alle altre cartelle
// BONUS leggibilità del codice e comprensione dell'esecuzione

		// Chi gioca e quante cartelle vogliono:
		// chiediamo in console il numero di giocatori e cartelle per giocatore.
		System.out.println("Quanti giocatori sono presenti in questa partita?: ");
		int nGiocatori = consoleInput.nextInt();
		System.out.println("Quante cartelle ogni giocatore ha a disposizione?: ");
		int nCartelle = consoleInput.nextInt();

		// Definiamo la struttura dati delle cartelle
		// Array di array per ogni giocatore, dove ogni giocatore ha nCartelle, ogni
		// cartella ha 15 numeri e il 16esimo è un contatore per vedere i numeri
		// estratti
		int[][][] cartellePerGiocatore = new int[nGiocatori][nCartelle][16];

		// Array che tiene conto delle estrazioni effettuate, false se non è presente
		// mentre true se è stato estratto
		// utilizzando questo approccio, perdiamo un dato importante, ovver l'ordine di
		// estrazione.
		boolean[] nEstratti = new boolean[90];

		// variabile boolean per la condizione di uscita della tombola.
		boolean tombola = false;

		// variabile per il numero estratto per il gioco della tombola.
		int numeroEstratto = 0;

		// variabile per contare il numero di estrazione attuale
		int contatoreEstrazione = 0;
		
		generazioneCartelle(cartellePerGiocatore, nGiocatori, nCartelle);
		/*
		// Generiamo le cartelle, ogni cartella ha 15 numeri diversi
		for (int i = 0; i < cartellePerGiocatore.length; i++) {
			for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
				// per ogni numero della cartella
				// ho aggiunto il - 1 perchè, da ragionamento, le cartelle contengono 16 valori,
				// di cui l'ultimo della colonna, è il numero di numeri estratti in quella
				// cartella.
				for (int k = 0; k < cartellePerGiocatore[i][j].length - 1; k++) {
					// generiamo un numero casuale graze a rng
					// controlliamo che non sia già stato inserito nella cartella, e nel caso
					// inserirlo.
					// per fare questo controllo, ho bisogno di mettere a confronto tutti i numeri
					// della cartella attuale con il numero generato.
					int numeroEstrattoCartella;
					boolean numeroPresente;
					// Verifica se il numero inserito non è presente nella cartella, se è presente
					// ricomincia il ciclo
					do {
						numeroPresente = false;
						numeroEstrattoCartella = rng.nextInt(90) + 1;
						for (int x = k; x >= 0; x--) {
							if (cartellePerGiocatore[i][j][x] == numeroEstrattoCartella)
								numeroPresente = true;
						}
					} while (numeroPresente);

					// inserisco il valore nella cartella
					cartellePerGiocatore[i][j][k] = numeroEstrattoCartella;
				}

			}
		}
		*/
		
		// inizio del gioco
		while (!tombola) {

			boolean isPresente;
			// estrazione elemento
			do {
				// imposto isPresente a true
				isPresente = true;
				// generiamo il valore
				numeroEstratto = rng.nextInt(90) + 1;
				if (!nEstratti[numeroEstratto - 1]) {
					// se il valore non è presente nell'array dei numeri estratti, allora lo assegno
					// al mio "Tabellone" ovvero nEstratti.
					// incremento anche il contatore per il numero dell'estrazione.
					nEstratti[numeroEstratto - 1] = true;
					isPresente = false;
					contatoreEstrazione++;
				}

			} while (isPresente);
			
			tombola = controlloCartelle(cartellePerGiocatore, numeroEstratto);
			/*
			// verifico che il numero estratto sia presente nelle cartelle dei giocatori
			for (int i = 0; i < cartellePerGiocatore.length; i++) {
				for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
					// cartellePerGiocatore[i][j] - 1 perchè il 16esimo elemento corrisponde al
					// nostro caro e amato contatore
					for (int k = 0; k < cartellePerGiocatore[i][j].length - 1; k++) {
						// controllo il numero estratto con i numeri all'interno delle cartelle
						if (numeroEstratto == cartellePerGiocatore[i][j][k]) {
							// incremento il 16esimo elemento
							cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]++;
							// verifico se la tombola è stata fatta.
							if (cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1] == 15) {
								tombola = true;
							}
						}
					}
				}
			}
			*
			// stampiamo il numero delle estrazioni
			System.out.println("Turno Estrazione: " + contatoreEstrazione);

			// numero estratto attualmente
			System.out.println("Numero Estratto: " + numeroEstratto);

			// numeri mancanti alle altre cartelle per ogni giocatore
			for (int i = 0; i < cartellePerGiocatore.length; i++) {
				System.out.println("Giocatore " + (i + 1) + ":");
				// per ogni cartella
				for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
					System.out.print("Cartella " + (j + 1) + ":");
					System.out.println("Numeri mancanti : "
							+ (15 - cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]));
				}

			}
			*/
			stampaTurno(cartellePerGiocatore, numeroEstratto, contatoreEstrazione);

			// per abbellire
			System.out.println();

		} // fine while

		// una volta usciti dal gioco, ovvero almeno una tombola è stata effettuata,
		// verranno stampati i dati finali:
		// ogni giocatore
		/*
		for (int i = 0; i < cartellePerGiocatore.length; i++) {
			// ogni cartella
			for (int j = 0; j < cartellePerGiocatore[i].length; j++) {
				if (cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1] == 15) {
					System.out.println("Il Giocatore " + (i + 1) + " ha vinto con la cartella: " + (j + 1));
				} else {
					System.out.println("La cartella del giocatore " + (i + 1) + " non ha vinto. Cartella " + (j + 1)
							+ ": Numeri mancanti : "
							+ (15 - cartellePerGiocatore[i][j][cartellePerGiocatore[i][j].length - 1]));

				}
			}
		}
		*/
		report(cartellePerGiocatore);

	} // FINE MAIN
}

//LOGICA TOMBOLA:
// A generazione avvenuta, inizio ad estrarre i numeri:
// Un numero che va da 1-90 deve essere estratto randomicamente tramite la funzione necessaria.

// Una volta estratto il numero randomico, verifichiamo che non sia già stato estratto.*
//*: Questo significa che avrò bisogno di controllare che il numero attuale randomico, non sia già presente nella totalità dei numeri estratti.

// Una volta verificato che non sia già stato estratto, controllo e segno* se è presente nelle cartelle dei giocatori.
//*: Per segnare, si intende incrementare un valore all'interno della struttura dati.

// !!! Per "struttura dati", intendo la struttura che racchiude i giocatori e le loro cartelle, dove, per ogni giocatore, 
// sarà presente un valore che parte da 0 fino a 15, che corrisponde all'ultimo elemento di ogni colonna.
// Il numero 15 rappresenta la tombola. Ogni numero precedente al 15, rappresenta la distanza dalla tombola.
// Ogni estrazione, verifico se ci sono cartelle vincitrici o no.

// Condizione di vittoria: Tombola (ovvero quando il numero ultimo presente nella colonna corrisponde a 15).
// Nel caso non ci fossero cartelle vincitrici dopo l'estrazione, allora il gioco continua, estraendo un altro numero.
// Se c'è una cartella vincitrice, fermo il flusso e raccolgo i dati necessari*.

//*: I dati necessari da raccogliere sono:
// i giocatori, il numero estratto*1, e quanti numeri mancano agli altri giocatori che non hanno vinto*2.
//*1: per recupare l'ultimo numero estratto, ho bisogno di una struttura dove immagazzinare tutti i numeri estratti in precedenza.
// Dopo che è stato estratto il numero della tombola dire chi ha vinto
//*2: per questo, utilizzerò l'ultimo valore della colonna, facendo la differenza tra 15 (Il numero massimo per la tombola) e il valore stesso.

/*
 * TO DO LIST (logica programma)
 * 
 * 
 * 0. Input utente OK 1. Definizione struttura dati OK (array di array di array)
 * 2. Generazione cartelle (con numeri unici) OK 3. Estrazione con
 * implementazione array di booleani dove gestiamo se un numero è già stato
 * estratto 4. Aggiorniamo cartelle se il numero è stato estratto (e il 16esimo
 * elemento dell'array andrà incrementato) 5. Per ogni iterazione stampa: numero
 * estrazioni, quanti numeri mancano alle altre cartelle, numero estratto 6.
 * Verifica se una cartella ha il 16elemento uguale a 15 (caso tombola) 7.
 * Stampa: nome vincitore,
 * 
 * 
 */
