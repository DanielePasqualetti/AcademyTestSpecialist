package giorno5;

import java.util.Random;

public class ArrayDiArray {

	public static void main(String[] args) {
		
		//array di array
		int[][] arrayDiArray = new int[5][5];
		
		//mi creo le variabili
		int sumDiagonalePrincipale = 0;
		int sumDiagonaleSecondaria = 0;
		int sumDiagonali = 0;
		
		//mi creo il generatore casuale di numeri
		Random random = new Random();

		//mi genero l'array di array
		for (int i = 0; i < arrayDiArray.length; i++) {
			for (int j = 0; j < arrayDiArray[i].length; j++) {
				arrayDiArray[i][j] = random.nextInt(100);
			}
		}

		//lo stampo
		System.out.println("Stampa dell'array: ");
		for (int i = 0; i < arrayDiArray.length; i++) {
			for (int j = 0; j < arrayDiArray[i].length; j++) {
				System.out.print(arrayDiArray[i][j] + "\t");
			}
			System.out.println();
		}

		//mi calcolo le somme delle due diagonali
		for (int i = 0; i < arrayDiArray.length; i++) {
			sumDiagonalePrincipale += arrayDiArray[i][i];
			sumDiagonaleSecondaria += arrayDiArray[i][arrayDiArray.length - 1 - i];
		}
		
		//mi sommo le due diagonali
		sumDiagonali = sumDiagonalePrincipale + sumDiagonaleSecondaria;
		
		//stampo tutto a schermo
		System.out.println("Somma della diagonale principale: " + sumDiagonalePrincipale);
		System.out.println("Somma della diagonale secondaria: " + sumDiagonaleSecondaria);
		System.out.println("Somma delle diagonali: " + sumDiagonali);
	}

}
