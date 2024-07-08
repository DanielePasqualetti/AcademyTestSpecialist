package com.example.ArabiRomani;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void shouldBeRoman() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(123);
    	assertEquals("CXXIII",str);
    }
    
    @Test
    public void shouldBeRoman1() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(654);
    	assertEquals("DCLIV",str);
    }
    
    @Test
    public void shouldBeRoman2() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(13);
    	assertEquals("XIII",str);
    }
    
    @Test
    public void shouldBeRoman3() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(999);
    	assertEquals("CMXCIX",str);
    }
    
    @Test
    public void shouldBeRoman4() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(1634);
    	assertEquals("MDCXXXIV",str);
    }
    
    @Test
    public void shouldBeRoman5() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(3612);
    	assertEquals("MMMDCXII",str);
    }
    
    @Test
    public void shouldBeRoman6() {
    	ArabiRomani ar = new ArabiRomani();
    	String str = ar.arabsToRomans(1111);
    	assertEquals("MCXI",str);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnError() {
    	ArabiRomani ar = new ArabiRomani();
    	ar.arabsToRomans(0);
    }
}
