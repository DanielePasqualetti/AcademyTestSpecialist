package esercizi;

public class Persona {

	private String nome;
	private String cognome;
	private int eta;

	// Costruttori
	// Costruttore di Default (vuoto)
	public Persona() {
		this.nome = "";
		this.cognome = "";
		this.eta = 0;
	}
	
	// Costruttore con parametri
	// lo scrivo in questo modo perché finché non utilizziamo
	// Hibernate ci gestiamo il NullPointException poiché non
	// rimane null l'oggetto ma viene istanziato con valori vuoti o zero
	public Persona(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}
	
	
	//Costruttore di copia
	
	
	

	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	
}
