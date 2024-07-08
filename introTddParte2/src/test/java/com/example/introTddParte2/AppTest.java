package com.example.introTddParte2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    /**
     * Verifica che il metodo generate della classe KuksaSauna restituisca il valore corretto per un input casuale.
     *
     * La procedura è la seguente:
     * 1. Si crea un'istanza della classe KuksaSauna.
     * 2. Si genera un numero casuale compreso tra 1 e 100.
     * 3. Si chiama il metodo generate con il numero casuale generato.
     * 4. Si verifica che l'ultimo elemento della lista restituita dal metodo generate sia corretto secondo le seguenti regole:
     *    - Se il numero è divisibile per 3, il valore deve essere "Kuksa!".
     *    - Se il numero è divisibile per 5, il valore deve essere "Sauna!".
     *    - Se il numero è divisibile sia per 3 che per 5, il valore deve essere "Kuksa!Sauna!".
     *    - Se il numero non è divisibile né per 3 né per 5, il valore deve essere il numero stesso come stringa.
     */
    @Test
    public void shouldReturnCorrectValueOnRandomInput() {
    	KuksaSauna ks = new KuksaSauna();
    	Random rng = new Random();
    	int valoreRandom = rng.nextInt(100) + 1;
    	ArrayList<String> lista = ks.generate(valoreRandom);
    	if(valoreRandom % 3 == 0) {
    		if(valoreRandom % 5 == 0) {
    			assertEquals("Kuksa!Sauna!", lista.get(valoreRandom - 1));
    		} else {
    			assertEquals("Kuksa!", lista.get(valoreRandom - 1));
    		}
    	} else if(valoreRandom % 5 == 0) {
    		assertEquals("Sauna!", lista.get(valoreRandom - 1));
    	} else {
    		assertEquals("" + valoreRandom, lista.get(valoreRandom - 1));
    	}
    }
    
    @Test
    public void shouldBeKuksa() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Kuksa!", lista.get(2));
    }
    
    @Test
    public void shouldBeKuksa2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Kuksa!", lista.get(5));
    }
    
    @Test
    public void shouldBeSauna() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Sauna!", lista.get(4));
    }
    
    @Test
    public void shouldBeSauna2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Sauna!", lista.get(9));
    }
    
    @Test
    public void shouldBeKuksaSauna() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Kuksa!Sauna!", lista.get(14));
    }
    
    @Test
    public void shouldBeKuksaSauna2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	assertEquals("Kuksa!Sauna!", lista.get(29));
    }
    
    @Test
    public void shouldBeKuksaX2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(7);
    	int contatore = 0;
    	for (String string : lista) {
			if(string.equals("Kuksa!")) {
				contatore++;
			}
		}
    	assertEquals(2,contatore);
    }
    
    @Test
    public void shouldBeSaunaX2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(14);
    	int contatore = 0;
    	for (String string : lista) {
			if(string.equals("Sauna!")) {
				contatore++;
			}
		}
    	assertEquals(2,contatore);
    }
    
    @Test
    public void shouldBeKuksaSaunaX2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(40);
    	int contatore = 0;
    	for (String string : lista) {
			if(string.equals("Kuksa!Sauna!")) {
				contatore++;
			}
		}
    	assertEquals(2,contatore);
    }
    
    @Test
    public void shouldBeIndex() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(10);
    	assertEquals("1", lista.get(0));
    }
    
    @Test
    public void shouldBeIndex2() {
    	KuksaSauna ks = new KuksaSauna();
    	ArrayList<String> lista = ks.generate(10);
    	assertEquals("7", lista.get(6));
    }
}
