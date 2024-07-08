package giorno4;

import java.util.Scanner;

public class Max {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		int max = 0;

		for (int i = 0; i < array.length; i++) {
			System.out.println("Inserisci il valore " + (i + 1) + " dell'array");
			array[i] = sc.nextInt();
			if(array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("Il valore massimo nell'array è: " + max);
	}
}
