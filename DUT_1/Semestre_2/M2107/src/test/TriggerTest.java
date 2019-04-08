import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;

import model.InitJDBC;
import model.Trigger;

public class TriggerTest{

	InitJDBC init = new InitJDBC("Test");
	Trigger trigger;
	
	@Before
	public void setUp(){
		trigger = new Trigger(init);
	}
	
	@Test
	public void getTriggerNameTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TRIGGER trigger1 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END;");
		init.query("CREATE TRIGGER trigger2 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END;");

		ArrayList<String> expected = new ArrayList<String>();
		expected.add("TRIGGER1");
		expected.add("TRIGGER2");
		ArrayList<String> result = trigger.getTriggerName();
		
		init.query("DROP TRIGGER trigger1;");
		init.query("DROP TRIGGER trigger2;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertTrue(result.equals(expected));
		
		expected.add("NON !");
		assertFalse(result.equals(expected));
		
	}
	
	@Test
	public void numberOfTriggerTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TRIGGER trigger1 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END;");
		init.query("CREATE TRIGGER trigger2 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END;");

		int expected = 2;
		int result = trigger.numberOfTrigger();
		
		init.query("DROP TRIGGER trigger1;");
		init.query("DROP TRIGGER trigger2;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertEquals(expected, result);
		
	}
	
	@Test
	public void getCodeTriggerTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TRIGGER trigger1 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END");
		
		String expected = "CREATE TRIGGER trigger1 AFTER INSERT ON REGISTRATION WHEN NEW.id == 04 BEGIN INSERT INTO REGISTRATION VALUES(02,'prenom','nom',102); END";
		expected = expected.toUpperCase();
		String result = trigger.getCodeTrigger("TRIGGER1");
		
		init.query("DROP TRIGGER trigger1;");
		init.query("DROP TABLE REGISTRATION;");
		
		assertEquals(expected, result);
		
	}

	
}
