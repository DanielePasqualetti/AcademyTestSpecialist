package pippo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
//		System.out.println("Inserisci un numero, se pari tornerà true");
//		int a = scanner.nextInt();
//		boolean res = pariDispari(a);
//		System.out.println(res);
		
		System.out.println("Inserisci due valori: ");
		int valore1 = scanner.nextInt();
		int valore2 = scanner.nextInt();
		System.out.println("Inserisci il valore da confrontare: ");		
		int valore3 = scanner.nextInt();
		int risultato = somma(valore1, valore2);
		confronto(risultato, valore3);
		
		
	}

	public static boolean pariDispari(int a) {
		return a % 2 == 0;
	}
	
	public static int somma(int a, int b) {
		return a + b;
	}
	
	public static void confronto(int a, int b) {
		if(a > b) {
			System.out.println(a + " è maggiore di " + b);
		} else {
			System.out.println(b + " è maggiore di " + a);
		}
	}
	
}
