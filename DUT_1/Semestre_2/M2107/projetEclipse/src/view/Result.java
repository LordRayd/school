package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * 
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class Result extends JDialog {

	/**
	 * This is the contentPane
	 */
	private JScrollPane scrollText;
	/**
	 * This is a TextPane where will be display the result
	 */
	private JTextPane textPane;
	/**
	 * This is the GUI where the Dialog will be open
	 */
	private GUI gui;

	/**
	 * This is the constructor it calls initComponent
	 * @param gui the GUI of the application
	 */
	public Result(GUI gui){
		super(gui, "Console");
		this.gui = gui;
		initComponent();

	}

	/**
	 * This procedure initialize the components
	 */
	public void initComponent(){
		scrollText = new JScrollPane();
		scrollText.setPreferredSize(new Dimension(400,200));
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollText.setViewportView(textPane);
		this.setContentPane(scrollText);
		setLocationRelativeTo(gui);
		setVisible(true);
		pack();
	}

	/**
	 * This is a getter
	 * @return the TextPane where the text is display
	 */
	public JTextPane getTextPane(){
		return textPane;
	}
}