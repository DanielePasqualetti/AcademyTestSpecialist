package giorno4;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		int[] array = new int[10];
		Scanner sc = new Scanner(System.in);
		System.out.println("Creiamo il nostro primo array");

		for (int i = 0; i < array.length; i++) {
			System.out.println("Inserisci il valore " + i+1 + " dell'array");
			array[i] = sc.nextInt();
		}
		System.out.println("L'array è composto dai seguenti valori");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
	}
}
