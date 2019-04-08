package view;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * This class will be the ActionBar at the bottom of the GUI 
 * @author Gurvan LORANS-CANO et Samuel LE BERRE
 * @version 1.0
 */
public class ActionBar extends JPanel{
	
	/**
	 * This attribute will be the GUI of the application
	 */
	private GUI frame;
	/**
	 * This a the only component for this class
	 */
	private JLabel action;
	
	/**
	 * This is the constructor
	 * @param frame the frame where the ActionBar will be add
	 */
	public ActionBar(GUI frame){
		if(frame != null){
			this.frame = frame;
		}
		initComponent();
		addComponent();
	}
	
	/**
	 * This method will initialize all the component for the class
	 */
	private void initComponent(){
		action = new JLabel("<html>Pr&ecirc;t</html>");
		setLayout(new BorderLayout());
	}
	
	/**
	 * This method will add the component to the class
	 */
	private void addComponent(){
		add(action, BorderLayout.WEST);
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

	/**
	 * This is a getter
	 * @return the JLabel where the action will be display
	 */
	public JLabel getAction() {
		return this.action;
	}
}