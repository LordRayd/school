package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controller.ClosableTabListener;

/**
 * Component to be used as tabComponent. Contains a JLabel to show the text and 
 * a JButton to close the tab
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */ 
public class ButtonTab extends JPanel {

	/**
	 * This JLabel will be the title of the tab
	 */
	private JLabel label;
	/**
	 * 
	 */
	private JTabbedPane pane;

	/**
	 * This is the constructor, it initializes the component and add them with an ActionListener(ClosableTabListener)
	 * @param pane The JTabbedPane where the ButtonTab will be put (we need the parameter for the Listener
	 * @param title The Title of the tab
	 */
	public ButtonTab(JTabbedPane pane, String title) {

		label = new JLabel(title);
		setOpaque(false);
		add(label);

		JButton button = new JButton();
		int size = 17;
		button.setPreferredSize(new Dimension(size, size));
		button.setToolTipText("close this tab");
		button.setContentAreaFilled(false);
		button.setText("X");
		button.setBorder(BorderFactory.createEtchedBorder());
		button.addActionListener(new ClosableTabListener(pane, this));
		add(button);
	}
}