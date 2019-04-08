import javax.swing.SwingUtilities;

import model.InitJDBC;
import view.Connection;

/**
 * @author Samuel LE BERRE & Gurvan LORANS-CANO
 * @version 1.0
 * @since JDK 1.8 
 */
public class Launcher {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable(){
					public void	run(){
						new Connection();
					}
				}
		);
	}
}
