import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;

import model.Table;
import model.InitJDBC;

public class TableTest{
	
	private InitJDBC init = new InitJDBC("Test");
	private Table table;
	@Before
	public void setUp(){
		table = new Table(init);
	}

	@Test
	public void returnTableTest(){
		init.query("CREATE TABLE registration ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("INSERT INTO REGISTRATION VALUES (04, 'Mahnaz', 'Fatma', 25);");

		HashMap<String, ResultSet> expected = new HashMap<String, ResultSet>();
		HashMap<String, ResultSet> result = table.returnTable("REGISTRATION");
		ResultSet rs = null;
		Statement stmt = null;

		try{
			stmt = this.init.getConnection().createStatement();
			String sql = "SELECT * FROM REGISTRATION;"; 
			rs = stmt.executeQuery(sql);
			expected.put(sql, rs);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		assertTrue(result.containsKey("SELECT * FROM REGISTRATION;"));

		ResultSet resultRS = result.get("SELECT * FROM REGISTRATION;");
		
		try{
			resultRS.next();
			assertTrue(resultRS.getString(1).equals("4"));
			assertTrue(resultRS.getString(2).equals("MAHNAZ"));
			assertTrue(resultRS.getString(3).equals("FATMA"));
			assertTrue(resultRS.getString(4).equals("25"));
			resultRS.close();
			expected.get("SELECT * FROM REGISTRATION;").close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		init.query("DROP TABLE REGISTRATION");
	}


	/**
	 * It could failed if the users already load table into the DataBase
	 */
	@Test
	public void getTableNameTest(){
		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TABLE registration2 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TABLE registration3 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");


		ArrayList<String> expected = new ArrayList<String>();
		expected.add("REGISTRATION1");
		expected.add("REGISTRATION2");
		expected.add("REGISTRATION3");
		
		ArrayList<String> result = table.getTableName();

		init.query("DROP TABLE REGISTRATION1");
		init.query("DROP TABLE REGISTRATION2");
		init.query("DROP TABLE REGISTRATION3");
		
		assertEquals(expected.size(), result.size());
		assertTrue(result.equals(expected));
	}
	
	/**
	 * It could failed if the users already load table into the DataBase
	 */
	@Test
	public void numberOfTableTest(){

		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TABLE registration2 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("CREATE TABLE registration3 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		int expected = 3;
		int result = table.numberOfTable();

		init.query("DROP TABLE REGISTRATION1");
		init.query("DROP TABLE REGISTRATION2");
		init.query("DROP TABLE REGISTRATION3");
		
		assertEquals(expected, result);
	}
	
	@Test
	public void numberOfColumnTest(){
		int expected = 4;
		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");

		int result = table.numberOfColumn("registration1");

		init.query("DROP TABLE REGISTRATION1");
		assertEquals(expected, result);
	}
	
	@Test
	public void getColumnNameTest(){
		String[] expected = {"ID", "FIRST", "LAST", "AGE"};
		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");

		String[] result = table.getColumnName("registration1");

		init.query("DROP TABLE REGISTRATION1");
		assertTrue(Arrays.equals(result, expected));
	}
	
	@Test
	public void nbTuplesTest(){
		int expected = 3;
		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("INSERT INTO REGISTRATION1 VALUES (03, 'Mahnaz', 'Fatma', 25);");
		init.query("INSERT INTO REGISTRATION1 VALUES (02, 'Mahnaz', 'Fatma', 25);");
		init.query("INSERT INTO REGISTRATION1 VALUES (01, 'Mahnaz', 'Fatma', 25);");

		int result = table.nbTuples("REGISTRATION1");

		init.query("DROP TABLE REGISTRATION1");
		assertEquals(expected, result);

	}
	
	@Test
	public void tableToArrayListTest(){
		ArrayList<String> expected = new ArrayList<String>();
		init.query("CREATE TABLE registration1 ( id CONSTRAINT pkId primary key , first varchar, last varchar , age integer)");
		init.query("INSERT INTO REGISTRATION1 VALUES (03, 'Mahnaz', 'Fatma', 25);");
		
		expected.add("REGISTRATION1");
		expected.add("4");
		expected.add("ID");
		expected.add("FIRST");
		expected.add("LAST");
		expected.add("AGE");
		expected.add("3");
		expected.add("MAHNAZ");
		expected.add("FATMA");
		expected.add("25");
		
		ArrayList<String> result = table.tableToArrayList("REGISTRATION1");
		
		init.query("DROP TABLE REGISTRATION1");
		assertTrue(result.equals(expected));
	}
	
	
	
	
	
}
