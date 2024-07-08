package eserciziListe;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {

	private List<Libro> libri;

	public Catalogo() {
		this.libri = new ArrayList<>();
	}

	public void aggiungiLibro(Libro libro) {
		libri.add(libro);
		System.out.println("Libro " + libro.getTitolo() + " aggiunto al catalogo.");
	}

	public void visualizzaCatalogo() {
		if (libri.isEmpty()) {
			System.out.println("Il catalogo è vuoìto.");
		} else {
			System.out.println("I libri presenti al momento sono: ");
			for (Libro libro : libri) {
				System.out.println(libro.toString());
			}
		}
	}

	public Libro cercaLibroPerTitolo(String titolo) {
		for (Libro libro : libri) {
			if (libro.getTitolo().toLowerCase().equals(titolo.toLowerCase())) {
				return libro;
			}
		}
		return null;
	}

	public void rimuoviLibro(String titolo) {
		for (int i = 0; i < libri.size(); i++) {
			if(libri.get(i).getTitolo().toLowerCase().equals(titolo.toLowerCase())) {
				Libro libroRimosso = libri.remove(i);
				System.out.println("Libro : " + libroRimosso.getTitolo() + " è stato rimosso.");
				return;
			}
		}
		System.out.println("Libro non trovato.");
	}


}
