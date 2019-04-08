import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.RWFile;

public class RWFileTest{
	
	/**
	 * Pour s'assurer du bon &eacute;tat de cette m&eacute; il faut s'assurer que la m&eacute;thode writeFile marche bien en ouvrant le fichier cr&eacute;&eacute; manuellement
	 */
	@Test
	public void readFileTest(){
		RWFile.writeFile("TEST", "Test_methode.txt");
		String expected = "TEST";
		String result = RWFile.readFile("Test_methode.txt");
		assertTrue(expected.equals(result));
	}
}
