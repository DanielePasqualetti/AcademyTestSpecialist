package Magazzino.com.magazzino;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.magazzino.Articolo;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void shouldCreateNewArticle() {
    	Articolo articolo = new Articolo();
    	articolo.setNome("Articolo di prova");
    	articolo.setDataDiScadenza(5);
    	articolo.setPrezzo(99.90);
    	articolo.setQualita(10);
    	
    	
    }
}
