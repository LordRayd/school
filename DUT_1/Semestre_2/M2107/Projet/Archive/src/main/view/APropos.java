package view;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.GUI;

public class APropos extends JDialog {
	
	private JLabel text;
	private GUI gui;
	
	public APropos(GUI gui){
		if(gui != null){
			this.gui = gui;
		}
		initComponent();
		addComponent();
		setLocationRelativeTo(gui);
		setVisible(true);
	}
	
	public void initComponent(){
		setPreferredSize(new Dimension(300,100));
		text = new JLabel("<html><center>Developp&eacute; par Samuel LE BERRE et Gurvan LORANS-CANO</center></html>");
		text.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void addComponent(){
		add(text);
		pack();
	}
}
