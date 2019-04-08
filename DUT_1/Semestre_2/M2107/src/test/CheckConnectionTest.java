import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.CheckConnection;
import java.util.HashMap;

public class CheckConnectionTest{

  @Test
  public void stringToMapTest(){
    CheckConnection check = new CheckConnection();
    HashMap<String, String> test = new HashMap<String,String>();
    test.put("u1","test");
    HashMap<String, String> fromCheck = check.stringToMap();
    assertEquals(test.size(), fromCheck.size());
    assertTrue(test.equals(fromCheck));
  }
}
