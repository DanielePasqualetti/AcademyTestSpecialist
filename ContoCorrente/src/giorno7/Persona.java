package giorno7;

public class Persona {

	private String nome;
	private String cognome;
	private String numero;
	private String email;
	

	//costruttori
	public Persona() {
		this.nome = "";
		this.cognome = "";
		this.numero = "";
		this.email = "";
	}

	public Persona(String nome, String cognome, String numero, String email) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numero = numero;
		this.email = email;
	}

	//getter e setter
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//tostring
	@Override
	public String toString() {
		return "Persona [nome=" + nome + ", cognome=" + cognome + ", numero=" + numero + ", email=" + email + "]";
	}

	
}
