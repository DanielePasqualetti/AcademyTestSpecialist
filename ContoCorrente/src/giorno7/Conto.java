package giorno7;

public class Conto {
	
	//VARIABILI
	private double soldi;
	
	
	//COSTRUTTORI
	public Conto(double soldi) {
		this.soldi = soldi;
	}
	
	
	//METODI
	public void printSaldo() {
		System.out.println("Hai " + soldi + "€ disponibili sul conto.");
	}
}
