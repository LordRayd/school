import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import model.InitJDBC;
import model.View;

public class ViewTest{
	InitJDBC init = new InitJDBC("Test");
	View view;
	
	@Before
	public void setUp(){
		view = new View(init);
	}
	
	@Test
	public void getViewNameTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE VIEW view1 AS SELECT id FROM REGISTRATION");
		init.query("CREATE VIEW view2 AS SELECT id FROM REGISTRATION");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("VIEW1");
		expected.add("VIEW2");
		ArrayList<String> result = view.getViewName();
		
		init.query("DROP VIEW view1;");
		init.query("DROP VIEW view2;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertTrue(result.equals(expected));
		
		expected.add("NON !");
		assertFalse(result.equals(expected));
	}
	
	@Test
	public void numberOfViewTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE VIEW view1 AS SELECT id FROM REGISTRATION");
		init.query("CREATE VIEW view2 AS SELECT id FROM REGISTRATION");
		int expected = 2;
		int result = view.numberOfView();
		
		init.query("DROP VIEW view1;");
		init.query("DROP VIEW view2;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertEquals(result, expected);
	}
	
	@Test
	public void numberColumnViewTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE VIEW view1 AS SELECT id, first FROM REGISTRATION");
		int expected = 2;
		int result = view.numberColumnView("VIEW1");
		
		init.query("DROP VIEW view1;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertEquals(result, expected);
	}
	
	@Test
	public void getCodeTriggerTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE VIEW view1 AS SELECT id, first FROM REGISTRATION");
		
		String expected = "CREATE VIEW view1 AS SELECT id, first FROM REGISTRATION";
		expected = expected.toUpperCase();
		String result = view.getCodeView("VIEW1");
		
		init.query("DROP VIEW view1;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertTrue(result.equals(expected));
		
	}
	
	@Test
	public void verifAttributTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE VIEW view1 AS SELECT id, first FROM REGISTRATION");
		
		ArrayList<String> listColumn = new ArrayList<String>();
		
		
		
		listColumn.add("ID");
		listColumn.add("FIRST");
		boolean result = view.verifAttribut("REGISTRATION", listColumn);
		
		assertTrue(result);
		
		listColumn.add("vbhgh");
		
		result = view.verifAttribut("REGISTRATION", listColumn);
		assertFalse(result);
		
		init.query("DROP VIEW view1;");
		init.query("DROP TABLE REGISTRATION;");
		
		
	}
	
	
}
