package letturaScrittura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Lettura {

	public static String percorso = System.getProperty("user.home") + "\\OneDrive\\Desktop\\testo.txt";
	public static String rigaTmp = "";
	public static ArrayList<String> testo = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
		    File f = new File(percorso);
		    FileReader fr = new FileReader(f);
		    BufferedReader br = new BufferedReader(fr);
		    while ((rigaTmp = br.readLine()) != null) {
		        testo.add(rigaTmp);
		    }
		    br.close();

		    Iterator<String> it = testo.iterator();
		    while (it.hasNext()) {
		        System.out.println(it.next());
		    }
		} catch (FileNotFoundException e) {
		    System.out.println("File non trovato");
		} catch (IOException e) {
		    System.out.println("Errore durante la lettura del file");
		} catch (Exception e) {
		    System.out.println("Eccezione generica");
		}


	}
}
