package rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rubrica {
	private static final String FILE_PATH = "rubrica.txt";
	private List<Contatto> contatti;

	public Rubrica() {
		contatti = new ArrayList<>();
		leggiRubrica();
	}

	public void aggiungiContatto(Contatto contatto) {
		contatti.add(contatto);
	}

	public void visualizzaRubrica() {
		for (Contatto contatto : contatti) {
			System.out.println(contatto);
		}
	}

	public void salvaRubrica() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Contatto contatto : contatti) {
				contatto.scriviSuFile(writer);
			}
		} catch (IOException e) {
			System.err.println("Errore durante il salvataggio della rubrica: " + e.getMessage());
		}
	}

	private void leggiRubrica() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String line;
			while ((line = reader.readLine()) != null) {
				contatti.add(Contatto.leggiDaFile(reader));
			}
		} catch (IOException e) {
			System.out.println("Non è stato possibile leggere la rubrica. Assicurati che il file esista.");
		}
	}
}