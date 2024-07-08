package com.example.ArabiRomani;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	
	static Scanner consoleInput = new Scanner(System.in);
	
    public static void main( String[] args ) {
    	
		ArabiRomani ar = new ArabiRomani();
		
		System.out.println("Inserisci un numero arabo da trascrivere in numero romano");
		
		int input = consoleInput.nextInt();
		
		System.out.println(ar.arabsToRomans(input));
    }
}
