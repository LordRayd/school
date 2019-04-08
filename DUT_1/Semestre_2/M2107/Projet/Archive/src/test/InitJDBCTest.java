import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;

import java.sql.SQLException;
import java.util.Arrays;

import model.InitJDBC;

public class InitJDBCTest{
	private static InitJDBC initToTest = new InitJDBC("Test");
  /**
   * Cette methode doit initialiser des méthodes par d&eacute;fauts dans la base de donn&eacute;es
   */
  @Test
  public void queryResultTest(){
	  
    initToTest.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
	initToTest.query("INSERT INTO REGISTRATION VALUES (04, 'Mahnaz', 'Fatma', 25);");
	
    String[] expected = {"REGISTRATION","ID		\n4		\n"};
    String[] result = initToTest.resultQuery("SELECT ID FROM REGISTRATION;");
    
    assertEquals(expected.length, result.length);
    assertTrue(Arrays.equals(expected, result));
  }
  
  @Test
  public void queryTest(){
    String[] expected = {new String(), new String()};
    
    String[] result = initToTest.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
	
    result = initToTest.query("DROP TABLE registration");
	assertEquals(expected.length, result.length);
    assertTrue(Arrays.equals(expected, result));
    
    result = initToTest.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
	assertEquals(expected.length, result.length);
    assertTrue(Arrays.equals(expected, result));
    
    result = initToTest.query("INSERT INTO REGISTRATION VALUES (04, 'Mahnaz', 'Fatma', 25);");
    assertEquals(expected.length, result.length);
    assertTrue(Arrays.equals(expected, result));
   
    result = initToTest.query("SELECT ID FROM REGISTRATION;");
	String[] expected2 = {"REGISTRATION","ID		\n4		\n"};
	
	assertEquals(expected2.length, result.length);
	assertTrue(Arrays.equals(expected2, result));
  }

	@Test
	public void getDb_NameTest() {
		initToTest.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");

		String expected = "jdbc:sqlite:Test";
		String result = initToTest.getDb_Name();
		assertTrue(expected.equals(result));
	}
	
	@After
	public void delete(){
		
		initToTest.query("DROP TABLE registration");
		
	}
	
	@AfterClass
	public static void deconnect(){
		try{
			initToTest.getConnection().close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}

