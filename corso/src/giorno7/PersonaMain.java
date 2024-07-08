package giorno7;

public class PersonaMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creo la nuova persona
		Persona persona1 = new Persona("Marco"); 
		
		//creo la seconda persona
		Persona persona2 = new Persona("Daniele");
		
		//richiamo il metodo per la prima persona
		persona1.printName();
		
		//richiamo il metodo per la seconda persona
		persona2.printName();
		
		//ottengo il valore nome della persona1
		String nomePersona1 = persona1.getNome();
		
		//stampo il valore preso e salvato nella variabile due volte
		System.out.println(nomePersona1 + nomePersona1);
		
		//sovrascrivo il nome dell'oggetto persona1
		persona1.setNome("Lorenzo");
		
		//chiamo il metodo su persona (output stampa lorenzo)
		persona1.printName();
		
		//stampo la variabile salvata in nomepersona1 (prima della modifica quindi output marco)
		System.out.println(nomePersona1);
		
	}

}
