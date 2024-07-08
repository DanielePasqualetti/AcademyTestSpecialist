package giorno4;

import java.util.Scanner;

public class ValoreMedio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		double somma = 0;

		System.out.println("Creiamo il nostro primo array");

		for (int i = 0; i < array.length; i++) {
			System.out.println("Inserisci il valore " + (i + 1) + " dell'array");
			array[i] = sc.nextInt();
			somma += array[i];
		}

		System.out.println("La media degli elementi inseriti è: " + somma / array.length);
	}

}
