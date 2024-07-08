package giorno7;

public class Persona {
	//variabili di istanza, anche dette campi
	private String nome;
	
	//costruttore
	public Persona(String nome) {
		this.nome = nome;
	}
	
	//metodo stampa del nome
	public void printName() {
		System.out.println("Ciao, mi chiamo " + nome);
	}
	
	//metodi per leggere e scrivere il nome chiamati accessori (getter e setter)
	//consente di leggere il valore di una variabile
	public String getNome() {
		return this.nome;
	}
	
	//per scrivere abbiamo i setter
	public void setNome(String nome) {
		this.nome = nome;
	}
}
