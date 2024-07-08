package letturaScrittura;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scrittura {
	static Scanner consoleInput = new Scanner(System.in);
	static String percorso = System.getProperty("user.home")+"\\OneDrive\\Desktop\\testo.txt";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			File f = new File(percorso);
			FileWriter fr = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fr);
			bw.write(consoleInput.nextLine());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Errore durante la scrittura del file");
		}
			
	}

}
