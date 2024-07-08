package giorno4;

import java.util.Scanner;

public class SommaPari {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		int somma = 0;

		System.out.println("Creiamo il nostro primo array");

		for (int i = 0; i < array.length; i++) {
			System.out.println("Inserisci il valore " + (i + 1) + " dell'array");
			array[i] = sc.nextInt();
			if(i % 2 == 0) {
				somma += array[i];
			}
		}
		System.out.println("La somma dei numeri in posizione pari è: " + somma);
	}

}
