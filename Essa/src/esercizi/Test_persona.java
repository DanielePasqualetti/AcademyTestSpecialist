package esercizi;

public class Test_persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p = new Persona();
		Persona p1 = new Persona("Vincienzo", "Coniglio", 36);
		System.out.println(p1);
		p1.setNome("Raffaele");
		System.out.println(p1);
		p.setNome("Daniele");
		p.setCognome("Pasqualetti");
		p.setEta(30);
		System.out.println(p);
	}

}
