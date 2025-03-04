package giorno5;

import java.util.Random;

public class Tombola {

	//inizializzo le costanti da 1 a 90
	static final int NUMERO_MAX = 90;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Voglio un app che simuli il gioco della tombola dalla a alla z con alcune semplificazioni
		//devo avere: un numero di giocatori e un numero di cartelle che ogni giocatore puo avere (ogni giocatore ha lo stesso numero di cartelle)
		//si vince solo con la tombola
		//voglio generare queste cartelle tramite il Random (generatore pseudo casuale 15 numeri da 1 a 90)
		//ad ogni estrazione bisogna sapere ad ogni cartella quanti numeri mancano, non ci devono essere numeri ripetuti nell'estrazione
		//bisogna tenere conto del numero delle estrazioni, di chi è la cartella, e quanti numeri mancavano alle altre cartelle
		//BONUS leggibilità del codice e com,prensione dell'esecuzione
		
		int numeroGiocatori = 3;
        int numeroCartellePerGiocatore = 2;

        
        //creo il gioco
        int[][][] cartelle = generaCartelle(numeroGiocatori, numeroCartellePerGiocatore);
        
        //creo un array per tenere copnto dei numeri estratti
        boolean[] arrayNumeriEstratti = new boolean[NUMERO_MAX];
        
        //contatore estraszioni
        int estrazioni = 0;

        //ciclo finche nbon c'e un vincitore
        while (true) {
            estrazioni++;
            int numeroEstratto;
            do {
                numeroEstratto = new Random().nextInt(NUMERO_MAX) + 1;
            } while (numeriEstratti(arrayNumeriEstratti, numeroEstratto));//controllo che il numero estratto non sia gia stato estratto in precedenza
            segnaNumeroEstratto(arrayNumeriEstratti, numeroEstratto);

            //stampo a schermo l'eastrazione
            System.out.println("Estratto il numero: " + numeroEstratto);
            
            //controllo se qualcuno ha vinto
            if (controllaVincita(cartelle, arrayNumeriEstratti)) {
                System.out.println("Tombola! Vincitore dopo " + estrazioni + " estrazioni.");
                break;
            }


            //aggiorno le cartelle
            aggiornaCartelle(cartelle, arrayNumeriEstratti, numeroEstratto);

            //stampo lo stato delle varie cartelle
            for (int i = 0; i < numeroGiocatori; i++) {
                for (int j = 0; j < numeroCartellePerGiocatore; j++) {
                    System.out.print("Giocatore " + (i + 1) + ", Cartella " + (j + 1) + ": ");
                    for (int k = 0; k < cartelle[i][j].length; k++) {
                        System.out.print(cartelle[i][j][k] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    //creo le varie cartelle per ogni giocatore
    private static int[][][] generaCartelle(int numeroGiocatori, int numeroCartelle) {
        int[][][] cartelle = new int[numeroGiocatori][numeroCartelle][15];
        Random random = new Random();

        for (int i = 0; i < numeroGiocatori; i++) {
            for (int j = 0; j < numeroCartelle; j++) {
                for (int k = 0; k < 15; k++) {
                    int numeroCasuale;
                    do {
                        numeroCasuale = random.nextInt(NUMERO_MAX) + 1;
                    } while (contieneNumero(cartelle[i][j], numeroCasuale));//controllo che non ci siano numeri ripetuti
                    cartelle[i][j][k] = numeroCasuale;
                }
                ordinaCartella(cartelle[i][j]);//ordino i numeri della cartella
            }
        }

        return cartelle;
    }

    //controllo se una cartella contiene il numero prendendo in input un array (la cartella) ed il numero da cercare (il numero casuale estratto)
    private static boolean contieneNumero(int[] array, int numero) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == numero) {
                return true;
            }
        }
        return false;
    }

    //riodino in modo crescente i numeri della cartella utilizzando il bubble sort
    private static void ordinaCartella(int[] cartella) {
        for (int i = 0; i < cartella.length - 1; i++) {
            for (int j = i + 1; j < cartella.length; j++) {
                if (cartella[i] > cartella[j]) {
                    int temp = cartella[i];
                    cartella[i] = cartella[j];
                    cartella[j] = temp;
                }
            }
        }
    }

    //segno un numero estratto
    private static void segnaNumeroEstratto(boolean[] numeriEstratti, int numero) {
        if (numero < 1 || numero > numeriEstratti.length) {
            return;
        }
        numeriEstratti[numero - 1] = true;
    }

    //controllo se il numero estratto è stato gia chiamato in precedenza
    private static boolean numeriEstratti(boolean[] numeriEstratti, int numero) {
        if (numero < 1 || numero > numeriEstratti.length) {
            return false;
        }
        return numeriEstratti[numero - 1];
    }


    //controllo se qualche giocatore ha vinto
    private static boolean controllaVincita(int[][][] cartelle, boolean[] arrayNumeriEstratti) {
        for (int i = 0; i < cartelle.length; i++) {
            for (int j = 0; j < cartelle[i].length; j++) {
                boolean vincita = true;
                for (int k = 0; k < cartelle[i][j].length; k++) {
                    int numeroCartella = cartelle[i][j][k];
                    if (numeroCartella != -1 && !arrayNumeriEstratti[numeroCartella - 1]) {
                        vincita = false;
                        break;
                    }
                }
                if (vincita) {
                    return true;
                }
            }
        }
        return false;
    }



    //aggiorno le cartelle con i valori estratti, cambiandoli in -1
    private static void aggiornaCartelle(int[][][] cartelle, boolean[] arrayNumeriEstratti, int numeroEstratto) {
        for (int i = 0; i < cartelle.length; i++) {
            for (int j = 0; j < cartelle[i].length; j++) {
                for (int k = 0; k < cartelle[i][j].length; k++) {
                    if (cartelle[i][j][k] == numeroEstratto) {//controllo che se il numero dell'indice k sia guuale al numero appena chiamato
                        cartelle[i][j][k] = -1; //segno il numero come estratto dentro òa cartella
                    }
                }
                ordinaCartella(cartelle[i][j]); //riordino la cartella dopo la rimozione del numero estratto
            }
        }
    }
	
}
