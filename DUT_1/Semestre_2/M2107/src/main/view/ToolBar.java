package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.ToolBarListener;

/**
 * The ToolBar of the Application
 * @author Gurvan LORANS et Samuel LE BERRE
 * @version 1.0
 */
public class ToolBar extends JPanel {

	/**
	 * The Button to have a New file
	 */
	private JButton newFile;
	/**
	 * The Button to Open a file
	 */
	private JButton open;
	/**
	 * The Button to Save
	 */
	private JButton save;
	/**
	 * The button to Save As
	 */
	private JButton saveAs;
	/**
	 * The Button to Print
	 */
	private JButton print;
	/**
	 * The panel left of the ToolBar
	 */
	private JPanel left;
	/**
	 * The GUI of the Application
	 */
	private GUI gui;

	/**
	 * This is the constructor, it calls initComponent and addComponent
	 * @param gui The GUI of the Application
	 */
	public ToolBar(GUI gui){
		if(gui != null){
			this.gui = gui;
		}
		setBackground(Color.GRAY);
		setLayout(new BorderLayout());
		initComponent();
		addComponent();
	}

	/**
	 * This procedure will initialize the component
	 */
	public void initComponent(){
		left = new JPanel();
		left.setLayout(new FlowLayout(1,10,5));
		left.setBackground(Color.GRAY);

		ImageIcon newIcon = new ImageIcon(new ImageIcon("data/new.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		ImageIcon saveIcon = new ImageIcon(new ImageIcon("data/save.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		ImageIcon saveAsIcon = new ImageIcon(new ImageIcon("data/saveAs.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		ImageIcon printIcon = new ImageIcon(new ImageIcon("data/print.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		ImageIcon openIcon = new ImageIcon(new ImageIcon("data/open.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));


		newFile = new JButton(newIcon);
		newFile.setToolTipText("Nouveau fichier");
		newFile.setMargin(new Insets(0, 0, 0, 0));
		newFile.setBackground(null);
		newFile.setBorder(null);
		newFile.addActionListener(new ToolBarListener(gui));

		open = new JButton(openIcon);
		open.setToolTipText("Ouvrir un fichier");
		open.setMargin(new Insets(0, 0, 0, 0));
		open.setBackground(null);
		open.setBorder(null);
		open.addActionListener(new ToolBarListener(gui));

		save = new JButton(saveIcon);
		save.setToolTipText("Enregistrer le fichier");
		save.setMargin(new Insets(0, 0, 0, 0));
		save.setBackground(null);
		save.setBorder(null);
		save.addActionListener(new ToolBarListener(gui));

		saveAs = new JButton(saveAsIcon);
		saveAs.setToolTipText("Enregistrer le fichier sous...");
		saveAs.setMargin(new Insets(0, 0, 0, 0));
		saveAs.setBackground(null);
		saveAs.setBorder(null);
		saveAs.addActionListener(new ToolBarListener(gui));

		print = new JButton(printIcon);
		print.setToolTipText("Imprimer");
		print.setMargin(new Insets(0, 0, 0, 0));
		print.setBackground(null);
		print.setBorder(null);
		print.addActionListener(new ToolBarListener(gui));
	}

	/**
	 * This procedure will add the component
	 */
	public void addComponent(){
		left.add(newFile);
		left.add(open);
		left.add(save);
		left.add(saveAs);
		left.add(print);
		add(left, BorderLayout.WEST);
	}

	/**
	 * Get the Button New
	 * @return The Button New
	 */
	public JButton getNewFile() {
		return newFile;
	}
	/**
	 * Get the Button Open
	 * @return The Button Open
	 */
	public JButton getOpen() {
		return open;
	}
	/**
	 * Get the Button Save
	 * @return The Button Save
	 */
	public JButton getSave() {
		return save;
	}
	/**
	 * Get the Button Save As
	 * @return The Button Save As
	 */
	public JButton getSaveAs() {
		return saveAs;
	}
	/**
	 * Get the Button Print
	 * @return The Button Print
	 */
	public JButton getPrint() {
		return print;
	}
}