package rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class Contatto {
    private String nome;
    private String numero;

    public Contatto(String nome, String numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return nome + ": " + numero;
    }

    public void scriviSuFile(BufferedWriter writer) throws IOException {
        writer.write(nome);
        writer.write(",");
        writer.write(numero);
        writer.newLine();
    }

    public static Contatto leggiDaFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] parts = line.split(",");
        return new Contatto(parts[0], parts[1]);
    }
}