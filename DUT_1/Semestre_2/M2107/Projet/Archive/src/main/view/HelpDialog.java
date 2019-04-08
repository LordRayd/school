package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.GUI;

public class HelpDialog extends JDialog {
	
	private GUI gui;
	private JLabel text;
	
	public HelpDialog(GUI gui){
		initComponent();
		addComponent();
		setVisible(true);
		setLocationRelativeTo(gui);
	}
	
	public void initComponent(){
			setPreferredSize(new Dimension(300,100));
			text = new JLabel("<html><center>Documentation SQLite<br/><a href=\"http://www.sqlite.org/docs.html\"> http://www.sqlite.org/docs.html </a></center></html>");
			text.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void addComponent(){
		add(text);
		pack();
	}
}
