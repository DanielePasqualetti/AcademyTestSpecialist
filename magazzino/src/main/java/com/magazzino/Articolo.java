package com.magazzino;

public class Articolo {

	private String nome;
	private int dataDiScadenza;
	private double prezzo;
	private int qualita;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getDataDiScadenza() {
		return dataDiScadenza;
	}
	public void setDataDiScadenza(int dataDiScadenza) {
		this.dataDiScadenza = dataDiScadenza;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQualita() {
		return qualita;
	}
	public void setQualita(int qualita) {
		this.qualita = qualita;
	}
	
}
