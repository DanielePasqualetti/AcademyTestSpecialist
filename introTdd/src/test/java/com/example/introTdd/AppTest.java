package com.example.introTdd;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    
    @Test
    public void calculatorShouldSum() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(4, c.somma(2, 2));
    }
    
    @Test
    public void calculatorShouldSum2() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(2, c.somma(1, 1));
    }
    
    @Test
    public void calculatorShouldSubtract() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(1, c.sottrazione(3, 2));
    }
    
    @Test
    public void calculatorShouldSubtract2() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(-1, c.sottrazione(2, 3));
    }
    
    @Test
    public void calculatorShouldMultiply() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(0, c.moltiplicazione(3, 0));
    }
    
    @Test
    public void calculatorShouldMultiply2() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(6, c.moltiplicazione(3, 2));
    }
    
    @Test
    public void calculatorShouldMultiply3() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(0, c.moltiplicazione(0, 0));
    }
    
    @Test
    public void calculatorShouldDivide() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(3, c.divisione(9, 3));
    }
    
    @Test
    public void calculatorShouldDivide2() {
    	assertThrows(ArithmeticException.class, () -> {
    		Calcolatrice c = new Calcolatrice();
    		c.divisione(3,0);
    	});
    }
    
    @Test
    public void calculatorShouldDivide3() {
    	Calcolatrice c = new Calcolatrice();
    	assertEquals(0, c.divisione(0, 3));
    }
}
