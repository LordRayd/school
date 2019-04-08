import static org.junit.Assert.assertEquals;
import org.junit.Test;
import model.Cryptage;


public class CryptageTest{
	@Test
	public void testDecrypt(){
		Cryptage crypt = new Cryptage();
		int[] cle = {1,2,3};
		String decrypt = crypt.decrypt("file/USERS_CRYPTED", cle);
		assertEquals("u1\ntest", decrypt);
	}
}
